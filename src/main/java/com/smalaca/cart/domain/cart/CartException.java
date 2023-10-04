package com.smalaca.cart.domain.cart;

import java.util.Map;
import java.util.UUID;

class CartException extends RuntimeException {
    static RuntimeException totalAmountExceeded(Amount totalAmount) {
        return null;
    }

    static RuntimeException couldNotBookAllProducts(Map<UUID, Amount> products) {
        return null;
    }
}
