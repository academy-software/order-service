package dev.softwareacademy.usecases.status;

import dev.softwareacademy.model.Order;
import dev.softwareacademy.model.PurchaseStatus;
import dev.softwareacademy.usecases.OrderUtils;
import io.micronaut.http.HttpMethod;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Optional;

@MicronautTest
class PurchaseStatusResourceTest {

    @Client("/purchases")
    @Inject
    RxHttpClient client;

    @Test
    void getPurchaseStatus() {
        HttpRequest<Order> request = HttpRequest
                .create(HttpMethod.POST, "/")
                .body(OrderUtils.buildOrder());

        //given that an order exists:
        Order orderCreated = Optional.ofNullable(client.toBlocking()
                .exchange(request, Order.class).body()).orElseThrow();

        //try to fetch status
        HttpResponse<PurchaseStatus> response = client.toBlocking()
                .exchange("/" + orderCreated.getId() + "/status", PurchaseStatus.class);

        Assertions.assertNotNull(orderCreated);

        //request should return status OK
        Assertions.assertEquals(
                HttpStatus.OK,
                response.status()
        );

        //and the status should be CREATED
        Assertions.assertEquals(
                Order.OrderStatus.CREATED,
                response.body().getStatus()
        );
    }
}