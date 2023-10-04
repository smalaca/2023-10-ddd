package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.AggregateRoot;

import java.util.UUID;

@AggregateRoot
public class Order {
    private final UUID cartId;
    private final UUID deliveryMethodId;
    private OrderState orderState;

    public Order(UUID cartId, UUID deliveryMethodId) {
        this.cartId = cartId;
        this.deliveryMethodId = deliveryMethodId;
    }

    public void cancel() {
        orderState = OrderState.CANCEL;
    }

    public void complete() {
        orderState = OrderState.COMPLETE;
    }
}
