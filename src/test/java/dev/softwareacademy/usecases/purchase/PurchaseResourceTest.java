package dev.softwareacademy.usecases.purchase;

import dev.softwareacademy.model.Order;
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
import java.util.Objects;

@MicronautTest
class PurchaseResourceTest {

    @Inject
    @Client("/purchases")
    RxHttpClient client;

    @Test
    void purchaseItem() {
        HttpRequest<Order> request = HttpRequest
                .create(HttpMethod.POST, "/")
                .body(OrderUtils.buildOrder());
        HttpResponse<Order> response = client.toBlocking().exchange(request, Order.class);

        Assertions.assertEquals(
                HttpStatus.CREATED,
                response.status()
        );

        Assertions.assertNotNull(Objects.requireNonNull(response.body()).getId());
    }
}