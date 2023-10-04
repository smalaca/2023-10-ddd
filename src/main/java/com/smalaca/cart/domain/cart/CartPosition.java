package com.smalaca.cart.domain.cart;

import com.smalaca.annotation.ddd.DomainEntity;
import com.smalaca.annotation.ddd.Factory;

import java.util.UUID;

@DomainEntity
class CartPosition {
    private final UUID productId;
    private final Amount amount;

    private CartPosition(UUID productId, Amount amount) {
        this.productId = productId;
        this.amount = amount;
    }

    @Factory
    static CartPosition create(UUID id, Integer amount) {
        return new CartPosition(id, Amount.amount(amount));
    }
}
