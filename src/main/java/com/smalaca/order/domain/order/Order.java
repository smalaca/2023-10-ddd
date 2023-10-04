package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.AggregateRoot;

import java.util.UUID;

@AggregateRoot
public class Order {
    private final UUID cartId;
    private final UUID deliveryMethodId;

    public Order(UUID cartId, UUID deliveryMethodId) {
        this.cartId = cartId;
        this.deliveryMethodId = deliveryMethodId;
    }
}
