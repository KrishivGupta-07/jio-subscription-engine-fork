package com.jio.subscription.payments.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.jayway.jsonpath.JsonPath;
import com.jio.subscription.payments.AbstractIntegrationTest;
import com.jio.subscription.payments.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
class PaymentIdempotencyIT extends AbstractIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PaymentRepository payments;

    private static final String PAYMENT = """
            {
              "account": { "id": "acct-1" },
              "paymentMethod": { "id": "pm-1" },
              "totalAmount": { "unit": "INR", "value": 249.0 }
            }
            """;

    private static final String PAYMENT_DIFFERENT = """
            {
              "account": { "id": "acct-1" },
              "paymentMethod": { "id": "pm-1" },
              "totalAmount": { "unit": "INR", "value": 999.0 }
            }
            """;

    @Test
    void duplicateIdempotencyKeyReplaysAndDoesNotDoubleCreate() throws Exception {
        String key = "idem-key-001";

        String firstBody = mockMvc.perform(post("/payment")
                        .header(IdempotencyKeys.HEADER, key)
                        .contentType(MediaType.APPLICATION_JSON).content(PAYMENT))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
        String firstId = JsonPath.read(firstBody, "$.id");

        String secondBody = mockMvc.perform(post("/payment")
                        .header(IdempotencyKeys.HEADER, key)
                        .contentType(MediaType.APPLICATION_JSON).content(PAYMENT))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        String secondId = JsonPath.read(secondBody, "$.id");

        assertThat(secondId).isEqualTo(firstId);
        assertThat(payments.findAll().stream().filter(p -> firstId.equals(p.getId())).count()).isEqualTo(1);
    }

    @Test
    void correlatorIdActsAsIdempotencyKeyWhenHeaderAbsent() throws Exception {
        String body = """
                {
                  "correlatorId": "corr-idem-77",
                  "account": { "id": "acct-1" },
                  "paymentMethod": { "id": "pm-1" },
                  "totalAmount": { "unit": "INR", "value": 50.0 }
                }
                """;

        String firstId = JsonPath.read(mockMvc.perform(post("/payment")
                        .contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString(), "$.id");

        String secondId = JsonPath.read(mockMvc.perform(post("/payment")
                        .contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString(), "$.id");

        assertThat(secondId).isEqualTo(firstId);
        assertThat(payments.findByCorrelatorId("corr-idem-77")).isPresent();
    }

    @Test
    void reusingKeyWithDifferentPayloadReturns409() throws Exception {
        String key = "idem-key-conflict";

        mockMvc.perform(post("/payment")
                        .header(IdempotencyKeys.HEADER, key)
                        .contentType(MediaType.APPLICATION_JSON).content(PAYMENT))
                .andExpect(status().isCreated());

        mockMvc.perform(post("/payment")
                        .header(IdempotencyKeys.HEADER, key)
                        .contentType(MediaType.APPLICATION_JSON).content(PAYMENT_DIFFERENT))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.code").value("409"));
    }
}
