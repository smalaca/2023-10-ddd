package com.smalaca.order.application.order;

import com.smalaca.order.domain.order.AcceptCartDomainCommand;
import com.smalaca.order.domain.order.Address;
import com.smalaca.order.domain.order.Amount;
import com.smalaca.order.domain.order.DeliveryMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public record AcceptCartCommand(
        UUID cartId, String deliveryMethod,
        String street, String postalCode, String city, String country, Map<UUID, Integer> products) {
    AcceptCartDomainCommand asAcceptCartCommand(UUID buyerId) {
        return new AcceptCartDomainCommand(buyerId, cartId, asDeliveryMethod(), asAddress(), asProducts());
    }

    private DeliveryMethod asDeliveryMethod() {
        return DeliveryMethod.deliveryMethod(deliveryMethod);
    }

    private Address asAddress() {
        return new Address(street, postalCode, city, country);
    }

    private Map<UUID, Amount> asProducts() {
        Map<UUID, Amount> products = new HashMap<>();
        this.products.forEach((id, amount) -> products.put(id, Amount.amount(amount)));
        return products;
    }
}
