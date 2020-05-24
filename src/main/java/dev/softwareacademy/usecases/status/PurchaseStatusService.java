package dev.softwareacademy.usecases.status;

import dev.softwareacademy.model.PurchaseStatus;

import java.util.UUID;

public interface PurchaseStatusService {

    PurchaseStatus getPurchaseStatus(UUID purchaseId);
}
