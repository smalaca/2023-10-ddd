package com.smalaca.cart.domain.productmanagementservice;

import com.smalaca.cart.domain.amount.Amount;

import java.util.Map;
import java.util.UUID;

public interface ProductManagementService {
    boolean book(Map<UUID, Amount> products);
}
