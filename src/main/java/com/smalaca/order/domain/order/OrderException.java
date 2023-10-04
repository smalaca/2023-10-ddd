package com.smalaca.order.domain.order;

import java.util.UUID;

class OrderException extends RuntimeException {
    static RuntimeException cartDoesNotExist(UUID cartId) {
        return null;
    }
}
