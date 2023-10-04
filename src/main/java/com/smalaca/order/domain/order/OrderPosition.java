package com.smalaca.order.domain.order;

import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
class OrderPosition {
    private final UUID productId;
    private final Amount amount;

    OrderPosition(UUID productId, Amount amount) {
        this.productId = productId;
        this.amount = amount;
    }
}
