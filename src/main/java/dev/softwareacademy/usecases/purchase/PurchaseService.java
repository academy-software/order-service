package dev.softwareacademy.usecases.purchase;

import dev.softwareacademy.model.Order;

public interface PurchaseService {

    Order createOrder(Order order);
}
