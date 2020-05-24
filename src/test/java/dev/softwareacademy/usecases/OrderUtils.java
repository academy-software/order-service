package dev.softwareacademy.usecases;

import dev.softwareacademy.model.Order;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderUtils {

    public static Order buildOrder() {
        Order order = new Order();
        order.setCustomerId(UUID.randomUUID());
        order.setItemId(UUID.randomUUID());
        order.setTotalAmount(BigDecimal.valueOf(13.45));

        return order;
    }
}
