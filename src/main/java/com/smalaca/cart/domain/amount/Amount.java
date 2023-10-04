package com.smalaca.cart.domain.amount;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public class Amount {
    public static final Amount ZERO = new Amount(0);
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

    @Factory
    public Amount increase(Amount amount) {
        return new Amount(this.value + amount.value);
    }

    public boolean greaterThan(int value) {
        return this.value > value;
    }

    public Integer getValue() {
        return value;
    }
}
