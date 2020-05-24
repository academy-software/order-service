package dev.softwareacademy.usecases.status;

import dev.softwareacademy.model.PurchaseStatus;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.UUID;

@Controller("/purchases")
public class PurchaseStatusResource {

    private PurchaseStatusService purchaseStatusService;

    public PurchaseStatusResource(PurchaseStatusService purchaseStatusService) {
        this.purchaseStatusService = purchaseStatusService;
    }

    @Get("/{id}/status")
    public HttpResponse<PurchaseStatus> getPurchaseStatus(UUID id) {
        return HttpResponse.ok(purchaseStatusService.getPurchaseStatus(id));
    }
}
