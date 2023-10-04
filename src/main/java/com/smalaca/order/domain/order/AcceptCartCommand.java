package com.smalaca.order.domain.order;

import com.smalaca.order.domain.order.DeliveryMethod;

import java.util.UUID;

public record AcceptCartCommand(UUID buyerId, UUID cartId, String deliveryMethod) {
    DeliveryMethod asDeliveryMethod() {
        return DeliveryMethod.deliveryMethod(deliveryMethod());
    }
}
