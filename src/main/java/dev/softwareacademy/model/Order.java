package dev.softwareacademy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.data.annotation.AutoPopulated;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
public class Order {

    @Id
    @AutoPopulated
    private UUID id;

    @JsonProperty("customer_id")
    private UUID customerId;

    @JsonProperty("item_id")
    private UUID itemId;

    @JsonProperty("total_amount")
    private BigDecimal totalAmount;

    private OrderStatus status;

    public enum OrderStatus {
        CREATED,
        PROCESSED,
        SHIPPED
    }
}
