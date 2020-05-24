package dev.softwareacademy.model;

import dev.softwareacademy.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseStatus {

    private UUID purchaseId;
    private Order.OrderStatus status;

    public static PurchaseStatus fromOrder(Order order) {
        return new PurchaseStatus(order.getId(), order.getStatus());
    }
}
