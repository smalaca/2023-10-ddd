package com.smalaca.cart.domain.cart;

import com.smalaca.annotation.ddd.DomainEntity;

import java.util.UUID;

@DomainEntity
class CartPosition {
    private final UUID productId;
    private Amount amount;

    CartPosition(UUID productId, Amount amount) {
        this.productId = productId;
        this.amount = amount;
    }

    boolean isFor(UUID productId) {
        return this.productId == productId;
    }

    void increase(Amount amount) {
        this.amount = this.amount.increase(amount);
    }

    Amount getAmount() {
        return amount;
    }
}
