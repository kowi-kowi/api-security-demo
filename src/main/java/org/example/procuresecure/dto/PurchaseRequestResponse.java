package org.example.procuresecure.dto;

import org.example.procuresecure.domain.PurchaseRequestStatus;
import java.math.BigDecimal;
import java.time.Instant;

public class PurchaseRequestResponse {
    public Long id;
    public String requesterEmail;
    public String vendor;
    public BigDecimal amount;
    public String description;
    public PurchaseRequestStatus status;
    public Instant createdAt;
    public Instant updatedAt;
}
