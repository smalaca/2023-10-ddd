package com.smalaca.cart.domain.cart;

import com.smalaca.annotation.ddd.DomainEvent;
import com.smalaca.cart.domain.amount.Amount;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@DomainEvent
@Getter
public class ProductsRemovedFromCartEvent {
    private final UUID eventId;
    private final LocalDateTime creationDateTime;
    private final UUID cartId;
    private final Map<UUID, Integer> products;

    private ProductsRemovedFromCartEvent(
            UUID eventId, LocalDateTime creationDateTime, UUID cartId, Map<UUID, Integer> products) {
        this.eventId = eventId;
        this.creationDateTime = creationDateTime;
        this.cartId = cartId;
        this.products = products;
    }

    static ProductsRemovedFromCartEvent create(UUID cartId, Map<UUID, Amount> productsWithAmount) {
        Map<UUID, Integer> products = new HashMap<>();
        productsWithAmount.forEach((id, amount) -> products.put(id, amount.getValue()));

        return new ProductsRemovedFromCartEvent(UUID.randomUUID(), LocalDateTime.now(), cartId, products);
    }
}
