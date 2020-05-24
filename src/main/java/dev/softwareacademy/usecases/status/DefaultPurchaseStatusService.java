package dev.softwareacademy.usecases.status;

import dev.softwareacademy.model.PurchaseStatus;
import dev.softwareacademy.repository.OrderRepository;

import java.util.UUID;

public class DefaultPurchaseStatusService implements PurchaseStatusService {

    private final OrderRepository orderRepository;

    public DefaultPurchaseStatusService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public PurchaseStatus getPurchaseStatus(UUID purchaseId) {
        return PurchaseStatus.fromOrder(
                orderRepository
                        .findById(purchaseId)
                        .orElseThrow(IllegalArgumentException::new)
        );
    }
}
