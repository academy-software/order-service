package dev.softwareacademy.repository;

import dev.softwareacademy.model.Order;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.UUID;

@JdbcRepository(dialect = Dialect.H2)
public interface OrderRepository extends CrudRepository<Order, UUID> {
}
