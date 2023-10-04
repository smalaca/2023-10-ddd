package com.smalaca.order.domain.order;

import java.util.Map;
import java.util.UUID;

public record AcceptCartDomainCommand(
        UUID buyerId, UUID cartId, DeliveryMethod deliveryMethod, Address address, Map<UUID, Amount> products) {
}
