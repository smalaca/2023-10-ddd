package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.annotation.ddd.Factory;
import com.smalaca.order.domain.price.Price;

import java.util.List;
import java.util.UUID;

@AggregateRoot
public class Order {
    private final OrderNumber orderNumber;
    private final UUID cartId;
    private final DeliveryMethod deliveryMethod;
    private final Address address;
    private final List<OrderPosition> orderPositions;
    private OrderState orderState;

    private Order(Builder builder) {
        this.orderNumber = builder.orderNumber;
        this.cartId = builder.cartId;
        this.deliveryMethod = builder.deliveryMethod;
        this.address = builder.address;
        this.orderState = builder.orderState;
        this.orderPositions = builder.orderPositions;
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

    @Factory
    public static class Builder {
        private List<OrderPosition> orderPositions;
        private OrderState orderState;
        private OrderNumber orderNumber;
        private UUID buyerId;
        private UUID cartId;
        private DeliveryMethod deliveryMethod;
        private Address address;

        Builder buyerId(UUID buyerId) {
            this.buyerId = buyerId;
            return this;
        }

        Builder cartId(UUID cartId) {
            this.cartId = cartId;
            return this;
        }

        Builder deliveryMethod(DeliveryMethod deliveryMethod) {
            this.deliveryMethod = deliveryMethod;
            return this;
        }

        Builder address(Address address) {
            this.address = address;
            return this;
        }

        void addPosition(UUID productId, Amount amount, Price price) {
            orderPositions.add(new OrderPosition(productId, amount, price));
        }

        Order build() {
            orderNumber = OrderNumber.orderNumber(buyerId);
            orderState = OrderState.PLACED;
            
            return new Order(this);
        }
    }
}
