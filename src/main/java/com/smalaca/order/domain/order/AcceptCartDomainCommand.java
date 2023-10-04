package com.smalaca.order.domain.order;

import com.smalaca.order.domain.address.Address;
import com.smalaca.order.domain.deliverymethod.DeliveryMethod;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

public record AcceptCartDomainCommand(
        UUID buyerId, UUID cartId, DeliveryMethod deliveryMethod, Address address, Map<UUID, Amount> products) {
    Set<UUID> productIds() {
        return products.keySet();
    }
}
