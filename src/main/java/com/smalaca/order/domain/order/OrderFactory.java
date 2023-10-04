package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.order.domain.cartservice.CartService;
import com.smalaca.order.domain.productmanagementservice.ProductManagementService;
import com.smalaca.order.domain.productmanagementservice.ProductPriceResponse;

@Factory
public class OrderFactory {
    private final CartService cartService;
    private final ProductManagementService productManagementService;

    public OrderFactory(CartService cartService, ProductManagementService productManagementService) {
        this.cartService = cartService;
        this.productManagementService = productManagementService;
    }

    public Order create(AcceptCartDomainCommand command) {
        Order.Builder builder = new Order.Builder()
                .buyerId(command.buyerId())
                .cartId(command.cartId())
                .deliveryMethod(command.deliveryMethod())
                .address(command.address());

        if (cartService.doesNotExist(command.cartId())) {
            throw OrderException.cartDoesNotExist(command.cartId());
        }

        ProductPriceResponse response = productManagementService.priceFor(command.productIds());

        command.products().forEach((productId, amount) -> {
            builder.addPosition(productId, amount, response.priceFor(productId));
        });

        return builder.build();
    }
}
