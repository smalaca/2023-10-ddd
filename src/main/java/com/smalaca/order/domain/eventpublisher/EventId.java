package com.smalaca.order.domain.eventpublisher;

import java.time.LocalDateTime;
import java.util.UUID;

public class EventId {
    private final UUID eventId;
    private final UUID traceId;
    private final LocalDateTime creationDateTime;

    private EventId(UUID eventId, UUID traceId, LocalDateTime creationDateTime) {
        this.eventId = eventId;
        this.traceId = traceId;
        this.creationDateTime = creationDateTime;
    }

    public static EventId create() {
        return new EventId(UUID.randomUUID(), UUID.randomUUID(), LocalDateTime.now());
    }
}
