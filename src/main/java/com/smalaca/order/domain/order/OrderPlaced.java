package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.DomainEvent;
import com.smalaca.order.domain.eventpublisher.EventId;
import lombok.Getter;

import java.util.UUID;

@DomainEvent
@Getter
public class OrderPlaced {
    private final EventId eventId;
    private final UUID cartId;
    private final OrderNumber orderNumber;

    private OrderPlaced(EventId eventId, UUID cartId, OrderNumber orderNumber) {
        this.eventId = eventId;
        this.cartId = cartId;
        this.orderNumber = orderNumber;
    }

    static OrderPlaced create(UUID cartId, OrderNumber orderNumber) {
        return new OrderPlaced(EventId.create(), cartId, orderNumber);
    }
}
