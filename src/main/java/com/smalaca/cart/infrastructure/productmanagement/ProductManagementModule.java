package com.smalaca.cart.infrastructure.productmanagement;

import com.smalaca.cart.domain.cart.Amount;
import com.smalaca.cart.domain.cart.ProductManagementService;

import java.util.Map;
import java.util.UUID;

public class ProductManagementModule implements ProductManagementService {
    @Override
    public boolean book(Map<UUID, Amount> products) {
        return false;
    }
}
