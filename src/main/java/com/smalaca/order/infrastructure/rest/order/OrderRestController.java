package com.smalaca.order.infrastructure.rest.order;

import com.smalaca.order.application.order.OrderApplicationService;

import java.util.UUID;

public class OrderRestController {
    private final OrderApplicationService orderApplicationService;

    public OrderRestController(OrderApplicationService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }

    public void acceptCart(UUID cartId, UUID deliveryMethodId) {
        orderApplicationService.acceptCart(cartId, deliveryMethodId);
    }
}
