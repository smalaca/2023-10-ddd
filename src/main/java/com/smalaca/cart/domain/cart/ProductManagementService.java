package com.smalaca.cart.domain.cart;

import java.util.Map;
import java.util.UUID;

public interface ProductManagementService {
    boolean book(Map<UUID, Amount> products);
}
