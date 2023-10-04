package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.annotation.ddd.ValueObject;

import java.util.UUID;

@ValueObject
class OrderNumber {
    private final String value;

    private OrderNumber(String value) {
        this.value = value;
    }

    @Factory
    static OrderNumber orderNumber(UUID buyerId) {
        return new OrderNumber(buyerId + "/" + UUID.randomUUID());
    }
}
