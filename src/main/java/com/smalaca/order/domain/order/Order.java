package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.AggregateRoot;

import java.util.UUID;

@AggregateRoot
public class Order {
    private final OrderNumber orderNumber;
    private final UUID cartId;
    private final DeliveryMethod deliveryMethod;
    private final Address address;
    private OrderState orderState;

    Order(OrderNumber orderNumber, UUID cartId, DeliveryMethod deliveryMethod, Address address, OrderState orderState) {
        this.orderNumber = orderNumber;
        this.cartId = cartId;
        this.deliveryMethod = deliveryMethod;
        this.address = address;
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
