package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.AggregateRoot;

import java.util.UUID;

@AggregateRoot
public class Order {
    private final UUID cartId;
    private final DeliveryMethod deliveryMethod;
    private OrderState orderState;

    Order(UUID cartId, DeliveryMethod deliveryMethod, OrderState orderState) {
        this.cartId = cartId;
        this.deliveryMethod = deliveryMethod;
        this.orderState = orderState;
    }

    public void cancel() {
        orderState = OrderState.CANCEL;
    }

    public void complete() {
        orderState = OrderState.COMPLETE;
    }

    public void resign() {
        orderState = OrderState.RESIGN;
    }
}
