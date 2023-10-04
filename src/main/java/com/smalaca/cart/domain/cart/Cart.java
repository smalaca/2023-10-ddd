package com.smalaca.cart.domain.cart;

import com.smalaca.annotation.ddd.AggregateRoot;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AggregateRoot
public class Cart {
    private final Set<UUID> products = new HashSet<>();

    public void addProducts(UUID productId) {
        products.add(productId);
    }
}
