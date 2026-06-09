package com.jio.subscription.payments.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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
class PaymentMethodApiIT extends AbstractIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private String createBankCard() throws Exception {
        return mockMvc.perform(post("/paymentMethod").contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"My Card\", \"@type\": \"bankCard\" }"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.@type").value("bankCard"))
                .andReturn().getResponse().getHeader("Location");
    }

    @Test
    void createRetrievePatchDeleteLifecycle() throws Exception {
        String location = createBankCard();

        mockMvc.perform(get(location))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("My Card"));

        mockMvc.perform(patch(location).contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"Renamed Card\" }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Renamed Card"))
                .andExpect(jsonPath("$.@type").value("bankCard"));

        mockMvc.perform(delete(location)).andExpect(status().isNoContent());
        mockMvc.perform(get(location)).andExpect(status().isNotFound());
    }

    @Test
    void unsupportedTypeIsRejectedWith400() throws Exception {
        mockMvc.perform(post("/paymentMethod").contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"X\", \"@type\": \"crypto\" }"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value("400"));
    }
}
