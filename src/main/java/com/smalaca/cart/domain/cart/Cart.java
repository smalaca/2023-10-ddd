package com.smalaca.cart.domain.cart;

import com.smalaca.annotation.ddd.AggregateRoot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@AggregateRoot
public class Cart {
    private final UUID buyerId;
    private final List<CartPosition> positions = new ArrayList<>();

    Cart(UUID buyerId) {
        this.buyerId = buyerId;
    }

    public void addProducts(Map<UUID, Amount> products, ProductManagementService productManagementService) {
        products.forEach((id, amount) -> {
            Optional<CartPosition> found = positions.stream().filter(position -> position.isFor(id)).findFirst();

            if (found.isPresent()) {
                found.get().increase(amount);
            } else {
                positions.add(new CartPosition(id, amount));
            }
        });

        if (isTotalAmountExceeded()) {
            throw CartException.totalAmountExceeded(totalAmount());
        }

        boolean response = productManagementService.book(products);

        if (!response) {
            throw CartException.couldNotBookAllProducts(products);
        }
    }

    private boolean isTotalAmountExceeded() {
        return totalAmount().greaterThan(20);
    }

    private Amount totalAmount() {
        return positions.stream()
                .map(CartPosition::getAmount)
                .reduce(Amount.ZERO, Amount::increase);
    }
}
