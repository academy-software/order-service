package dev.softwareacademy.usecases.purchase;

import dev.softwareacademy.model.Order;
import dev.softwareacademy.repository.OrderRepository;

public class DefaultPurchaseService implements PurchaseService {

    private final OrderRepository orderRepository;

    public DefaultPurchaseService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        order.setStatus(Order.OrderStatus.CREATED);
        return orderRepository.save(order);
    }
}
