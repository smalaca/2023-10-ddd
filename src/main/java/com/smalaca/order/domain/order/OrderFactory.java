package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.Factory;

import java.util.UUID;

@Factory
public class OrderFactory {
    public Order create(UUID cartId, DeliveryMethod deliveryMethodVO) {
        return new Order(cartId, deliveryMethodVO, OrderState.PLACED);
    }
}
