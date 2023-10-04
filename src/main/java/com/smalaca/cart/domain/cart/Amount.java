package com.smalaca.cart.domain.cart;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
class Amount {
    private final int value;

    private Amount(int value) {
        this.value = value;
    }

    @Factory
    static Amount amount(int value) {
        if (value < 1) {
            throw new AmountException(value);
        }

        return new Amount(value);
    }
}
