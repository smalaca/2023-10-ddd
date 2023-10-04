package com.smalaca.cart.application.cart;

import com.smalaca.cart.domain.cart.Cart;
import com.smalaca.cart.domain.cart.CartRepository;

import java.util.UUID;

public class CartApplicationService {
    private final CartRepository cartRepository;

    public CartApplicationService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addProducts(UUID cartId, UUID productId) {
        // 1. tłumaczenie na język domeny [0...*]
        Cart cart = cartRepository.findById(cartId);

        // 2. wywołanie JEDNEJ metody z domeny
        cart.addProducts(productId);

        // 3. zapis zmian agregatów [1...*]
        cartRepository.save(cart);
    }
}
