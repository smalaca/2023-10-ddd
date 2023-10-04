package com.smalaca.cart.domain.cart;

import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.cart.domain.amount.Amount;
import com.smalaca.cart.domain.eventpublisher.EventPublisher;
import com.smalaca.cart.domain.productmanagementservice.ProductManagementService;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@AggregateRoot
public class Cart extends AbstractAggregateRoot<Cart> {
    private final UUID cartId;
    private final UUID buyerId;
    private final List<CartPosition> positions = new ArrayList<>();

    Cart(UUID cartId, UUID buyerId) {
        this.cartId = cartId;
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

    public void removeProducts(Map<UUID, Amount> products, EventPublisher eventPublisher) {
        ProductsRemovedFromCartEvent event = ProductsRemovedFromCartEvent.create(cartId, products);
        eventPublisher.publish(event);
    }
}
