package com.smalaca.order.domain.eventpublisher;

import com.smalaca.order.domain.order.OrderPlaced;

public interface EventPublisher {
    void publish(OrderPlaced orderPlaced);
}
