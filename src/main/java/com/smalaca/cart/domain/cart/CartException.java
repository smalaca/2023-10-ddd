package com.smalaca.cart.domain.cart;

class CartException extends RuntimeException {
    static RuntimeException totalAmountExceeded(Amount totalAmount) {
        return null;
    }
}
