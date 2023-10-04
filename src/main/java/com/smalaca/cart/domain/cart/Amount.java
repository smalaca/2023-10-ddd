package com.smalaca.cart.domain.cart;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public class Amount {
    private final int value;

    private Amount(int value) {
        this.value = value;
    }

    @Factory
    public static Amount amount(int value) {
        if (value < 1) {
            throw new AmountException(value);
        }

        return new Amount(value);
    }

    Amount increase(Amount amount) {
        return new Amount(this.value + amount.value);
    }
}
