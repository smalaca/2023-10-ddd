package com.smalaca.order.infrastructure.rest.order;

import com.smalaca.order.domain.order.AcceptCartCommand;
import com.smalaca.order.application.order.OrderApplicationService;

import java.util.UUID;

public class OrderRestController {
    private final OrderApplicationService orderApplicationService;

    public OrderRestController(OrderApplicationService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }

    public void acceptCart(UUID cartId, String deliveryMethod) {
        orderApplicationService.acceptCart(new AcceptCartCommand(buyerId(), cartId, deliveryMethod));
    }

    private UUID buyerId() {
        // retrieved from session
        return UUID.randomUUID();
    }

    public void cancel(UUID orderId) {
        orderApplicationService.cancel(orderId);
    }

    public void confirmDeliveryReception(UUID orderId) {
        orderApplicationService.complete(orderId);
    }

    public void resign(UUID orderId) {
        orderApplicationService.resign(orderId);
    }
}
