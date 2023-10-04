package com.smalaca.order.domain.cartservice;

import java.util.UUID;

public interface CartService {
    boolean doesNotExist(UUID cartId);
}
