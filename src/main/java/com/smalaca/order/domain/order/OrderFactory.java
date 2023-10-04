package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.Factory;

@Factory
public class OrderFactory {
    public Order create(AcceptCartDomainCommand command) {
        Order.Builder builder = new Order.Builder()
                .buyerId(command.buyerId())
                .cartId(command.cartId())
                .deliveryMethod(command.deliveryMethod())
                .address(command.address());

        command.products().forEach(builder::addPosition);

        return builder.build();
    }
}
