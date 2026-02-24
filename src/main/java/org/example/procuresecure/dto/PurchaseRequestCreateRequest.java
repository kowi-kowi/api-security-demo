package org.example.procuresecure.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class PurchaseRequestCreateRequest {

    @NotBlank
    @Email
    public String requesterEmail;

    @NotBlank
    @Size(max = 200)
    public String vendor;

    @NotNull
    @Positive
    public BigDecimal amount;

    @NotBlank
    @Size(max = 2000)
    public String description;
}
