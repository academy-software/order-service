package dev.softwareacademy.factory;

import dev.softwareacademy.repository.OrderRepository;
import dev.softwareacademy.usecases.purchase.DefaultPurchaseService;
import dev.softwareacademy.usecases.purchase.PurchaseService;
import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;

@Factory
public class PurchaseServiceFactory {

    @Singleton
    PurchaseService createPurchaseService(OrderRepository orderRepository) {
        return new DefaultPurchaseService(orderRepository);
    }
}
