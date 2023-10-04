package com.smalaca.cart.domain.cart;

import com.smalaca.annotation.ddd.AggregateRoot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AggregateRoot
public class Cart {
    private final UUID buyerId;
    private final List<CartPosition> positions = new ArrayList<>();

    Cart(UUID buyerId) {
        this.buyerId = buyerId;
    }

    public void addProducts(Map<UUID, Integer> products) {
        products.forEach((id, amount) -> {
            // zwiększyć ilość produktu, jeżeli istnieje odpowiednia pozycja

            positions.add(CartPosition.create(id, amount));
        });

        // ilość produktów nie większa niż 20
    }
}
