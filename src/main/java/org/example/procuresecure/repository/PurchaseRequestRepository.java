package org.example.procuresecure.repository;

import org.example.procuresecure.domain.PurchaseRequest;
import org.example.procuresecure.domain.PurchaseRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequest, Long> {
    List<PurchaseRequest> findByRequesterEmail(String requesterEmail);
    List<PurchaseRequest> findByStatus(PurchaseRequestStatus status);
}