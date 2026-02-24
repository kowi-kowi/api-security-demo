package org.example.procuresecure.service;


import org.example.procuresecure.domain.PurchaseRequest;
import org.example.procuresecure.domain.PurchaseRequestStatus;
import org.example.procuresecure.dto.PurchaseRequestCreateRequest;
import org.example.procuresecure.repository.PurchaseRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PurchaseRequestService {

    private final PurchaseRequestRepository repo;

    public PurchaseRequestService(PurchaseRequestRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public PurchaseRequest create(PurchaseRequestCreateRequest req) {
        PurchaseRequest pr = new PurchaseRequest();
        pr.setRequesterEmail(req.requesterEmail);
        pr.setVendor(req.vendor);
        pr.setAmount(req.amount);
        pr.setDescription(req.description);
        pr.setStatus(PurchaseRequestStatus.DRAFT);
        return repo.save(pr);
    }

    @Transactional(readOnly = true)
    public PurchaseRequest getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Purchase request not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<PurchaseRequest> listAll() {
        return repo.findAll();
    }
}
