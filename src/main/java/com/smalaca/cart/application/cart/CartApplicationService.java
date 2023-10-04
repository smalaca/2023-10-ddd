package com.smalaca.cart.application.cart;

import com.smalaca.cart.domain.cart.Amount;
import com.smalaca.cart.domain.cart.Cart;
import com.smalaca.cart.domain.cart.CartRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CartApplicationService {
    private final CartRepository cartRepository;

    public CartApplicationService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addProducts(UUID cartId, Map<UUID, Integer> products) {
        // 1. tłumaczenie na język domeny [0...*]
        Cart cart = cartRepository.findById(cartId);

        // 2. wywołanie JEDNEJ metody z domeny
        cart.addProducts(asProducts(products));

        // 3. zapis zmian agregatów [1...*]
        cartRepository.save(cart);
    }

    private Map<UUID, Amount> asProducts(Map<UUID, Integer> input) {
        Map<UUID, Amount> products = new HashMap<>();
        input.forEach((id, amount) -> products.put(id, Amount.amount(amount)));
        return products;
    }
}
