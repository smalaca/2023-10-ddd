package com.smalaca.order.domain.order;

import java.util.UUID;

public record AcceptCartCommand(
        UUID buyerId, UUID cartId, String deliveryMethod,
        String street, String postalCode, String city, String country) {
    DeliveryMethod asDeliveryMethod() {
        return DeliveryMethod.deliveryMethod(deliveryMethod());
    }

    Address asAddress() {
        return new Address(street, postalCode, city, country);
    }
}
