package org.example.procuresecure;

import org.example.procuresecure.dto.PurchaseRequestCreateRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PurchaseRequestIntegrationTest {

    @Autowired MockMvc mvc;
    @Autowired ObjectMapper om;

    @Test
    void createPurchaseRequest_returns201() throws Exception {
        PurchaseRequestCreateRequest req = new PurchaseRequestCreateRequest();
        req.requesterEmail = "requester@example.com";
        req.vendor = "ACME Corp";
        req.amount = new BigDecimal("123.45");
        req.description = "New laptop";

        mvc.perform(post("/requests")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(req)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.status").value("DRAFT"));
    }

    @Test
    void createPurchaseRequest_invalidAmount_returns400() throws Exception {
        PurchaseRequestCreateRequest req = new PurchaseRequestCreateRequest();
        req.requesterEmail = "requester@example.com";
        req.vendor = "ACME Corp";
        req.amount = new BigDecimal("-1");
        req.description = "Invalid";

        mvc.perform(post("/requests")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(req)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.title").value("Validation failed"));
    }
}
