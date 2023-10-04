package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.Factory;

import java.util.UUID;

@Factory
public class OrderFactory {
    public Order create(UUID buyerId, UUID cartId, DeliveryMethod deliveryMethodVO) {
        OrderNumber orderNumber = OrderNumber.orderNumber(buyerId);
        return new Order(orderNumber, cartId, deliveryMethodVO, OrderState.PLACED);
    }
}
