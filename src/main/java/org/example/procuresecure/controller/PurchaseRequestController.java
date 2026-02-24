package org.example.procuresecure.controller;

import org.example.procuresecure.domain.PurchaseRequest;
import org.example.procuresecure.dto.PurchaseRequestCreateRequest;
import org.example.procuresecure.dto.PurchaseRequestResponse;
import org.example.procuresecure.service.PurchaseRequestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class PurchaseRequestController {

    private final PurchaseRequestService service;

    public PurchaseRequestController(PurchaseRequestService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PurchaseRequestResponse create(@Valid @RequestBody PurchaseRequestCreateRequest req) {
        return toResponse(service.create(req));
    }

    @GetMapping("/{id}")
    public PurchaseRequestResponse get(@PathVariable Long id) {
        return toResponse(service.getById(id));
    }

    @GetMapping
    public List<PurchaseRequestResponse> list() {
        return service.listAll().stream().map(this::toResponse).toList();
    }

    private PurchaseRequestResponse toResponse(PurchaseRequest pr) {
        PurchaseRequestResponse r = new PurchaseRequestResponse();
        r.id = pr.getId();
        r.requesterEmail = pr.getRequesterEmail();
        r.vendor = pr.getVendor();
        r.amount = pr.getAmount();
        r.description = pr.getDescription();
        r.status = pr.getStatus();
        r.createdAt = pr.getCreatedAt();
        r.updatedAt = pr.getUpdatedAt();
        return r;
    }
}