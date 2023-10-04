package com.smalaca.order.domain.order;

import com.smalaca.order.domain.price.Price;
import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
class OrderPosition {
    private final UUID productId;
    private final Amount amount;
    private final Price price;

    OrderPosition(UUID productId, Amount amount, Price price) {
        this.productId = productId;
        this.amount = amount;
        this.price = price;
    }
}
