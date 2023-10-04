package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.Factory;

@Factory
public class OrderFactory {
    public Order create(AcceptCartCommand command) {
        OrderNumber orderNumber = OrderNumber.orderNumber(command.buyerId());

        return new Order(orderNumber, command.cartId(), command.asDeliveryMethod(), OrderState.PLACED);
    }
}
