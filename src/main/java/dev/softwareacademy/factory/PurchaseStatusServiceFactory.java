package dev.softwareacademy.factory;

import dev.softwareacademy.repository.OrderRepository;
import dev.softwareacademy.usecases.status.DefaultPurchaseStatusService;
import dev.softwareacademy.usecases.status.PurchaseStatusService;
import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;

@Factory
public class PurchaseStatusServiceFactory {

    @Singleton
    PurchaseStatusService createPurchaseStatusService(OrderRepository orderRepository) {
        return new DefaultPurchaseStatusService(orderRepository);
    }
}
