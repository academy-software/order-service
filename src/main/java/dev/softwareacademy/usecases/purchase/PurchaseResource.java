package dev.softwareacademy.usecases.purchase;

import dev.softwareacademy.model.Order;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/purchases/")
public class PurchaseResource {

    private final PurchaseService purchaseService;

    public PurchaseResource(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Post(processes = MediaType.APPLICATION_JSON)
    public HttpResponse<Order> purchaseItem(Order order) {
        Order orderCreated = purchaseService.createOrder(order);
        return HttpResponse.created(orderCreated);
    }

}
