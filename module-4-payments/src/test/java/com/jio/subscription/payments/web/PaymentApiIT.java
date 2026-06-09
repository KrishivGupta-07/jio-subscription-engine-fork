package com.jio.subscription.payments.web;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.jio.subscription.payments.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
class PaymentApiIT extends AbstractIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String VALID_PAYMENT = """
            {
              "correlatorId": "%s",
              "account": { "id": "acct-1" },
              "paymentMethod": { "id": "pm-1" },
              "totalAmount": { "unit": "INR", "value": 249.0 }
            }
            """;

    @Test
    void createReturns201WithInitiatedStatusAndHref() throws Exception {
        mockMvc.perform(post("/payment").contentType(MediaType.APPLICATION_JSON)
                        .content(VALID_PAYMENT.formatted("corr-create")))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(notNullValue()))
                .andExpect(jsonPath("$.status").value("initiated"))
                .andExpect(jsonPath("$.href").value(containsString("/payment/")))
                .andExpect(jsonPath("$.totalAmount.value").value(249.0));
    }

    @Test
    void retrieveReturnsCreatedPayment() throws Exception {
        String location = mockMvc.perform(post("/payment").contentType(MediaType.APPLICATION_JSON)
                        .content(VALID_PAYMENT.formatted("corr-retrieve")))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getHeader("Location");

        mockMvc.perform(get(location))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.correlatorId").value("corr-retrieve"))
                .andExpect(jsonPath("$.status").value("initiated"));
    }

    @Test
    void retrieveUnknownReturnsTmfError404() throws Exception {
        mockMvc.perform(get("/payment/does-not-exist"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value("404"))
                .andExpect(jsonPath("$.reason").value("Not Found"))
                .andExpect(jsonPath("$.status").value("404"));
    }

    @Test
    void invalidPaymentReturnsTmfError400() throws Exception {
        mockMvc.perform(post("/payment").contentType(MediaType.APPLICATION_JSON).content("{}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value("400"))
                .andExpect(jsonPath("$.reason").value("Bad Request"));
    }

    @Test
    void fieldsParameterRestrictsAttributes() throws Exception {
        String location = mockMvc.perform(post("/payment").contentType(MediaType.APPLICATION_JSON)
                        .content(VALID_PAYMENT.formatted("corr-fields")))
                .andReturn().getResponse().getHeader("Location");

        mockMvc.perform(get(location + "?fields=status"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("initiated"))
                .andExpect(jsonPath("$.id").value(notNullValue()))
                .andExpect(jsonPath("$.correlatorId").doesNotExist())
                .andExpect(jsonPath("$.totalAmount").doesNotExist());
    }

    @Test
    void listReturnsArray() throws Exception {
        mockMvc.perform(post("/payment").contentType(MediaType.APPLICATION_JSON)
                .content(VALID_PAYMENT.formatted("corr-list")));

        mockMvc.perform(get("/payment?limit=5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}
