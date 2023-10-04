package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.annotation.ddd.Factory;

import java.util.UUID;

@AggregateRoot
public class Order {
    private final UUID cartId;
    private final UUID deliveryMethodId;
    private OrderState orderState;

    private Order(UUID cartId, UUID deliveryMethodId, OrderState orderState) {
        this.cartId = cartId;
        this.deliveryMethodId = deliveryMethodId;
        this.orderState = orderState;
    }

    @Factory
    public static Order create(UUID cartId, UUID deliveryMethodId) {
        return new Order(cartId, deliveryMethodId, OrderState.PLACED);
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
