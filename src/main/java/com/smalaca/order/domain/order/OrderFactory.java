package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.order.domain.cartservice.CartService;

@Factory
public class OrderFactory {
    private final CartService cartService;

    public OrderFactory(CartService cartService) {
        this.cartService = cartService;
    }

    public Order create(AcceptCartDomainCommand command) {
        Order.Builder builder = new Order.Builder()
                .buyerId(command.buyerId())
                .cartId(command.cartId())
                .deliveryMethod(command.deliveryMethod())
                .address(command.address());

        command.products().forEach(builder::addPosition);

        if (cartService.doesNotExist(command.cartId())) {
            throw OrderException.cartDoesNotExist(command.cartId());
        }
        return builder.build();
    }
}
