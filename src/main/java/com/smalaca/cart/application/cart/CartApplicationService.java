package com.smalaca.cart.application.cart;

import com.smalaca.cart.domain.cart.Amount;
import com.smalaca.cart.domain.cart.Cart;
import com.smalaca.cart.domain.cart.CartRepository;
import com.smalaca.cart.domain.cart.ProductManagementService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CartApplicationService {
    private final CartRepository cartRepository;
    private final ProductManagementService productManagementService;

    public CartApplicationService(CartRepository cartRepository, ProductManagementService productManagementService) {
        this.cartRepository = cartRepository;
        this.productManagementService = productManagementService;
    }

    public void addProducts(UUID cartId, Map<UUID, Integer> products) {
        // 1. tłumaczenie na język domeny [0...*]
        Cart cart = cartRepository.findById(cartId);

        // 2. wywołanie JEDNEJ metody z domeny
        cart.addProducts(asProducts(products), productManagementService);

        // 3. zapis zmian agregatów [1...*]
        cartRepository.save(cart);
    }

    private Map<UUID, Amount> asProducts(Map<UUID, Integer> input) {
        Map<UUID, Amount> products = new HashMap<>();
        input.forEach((id, amount) -> products.put(id, Amount.amount(amount)));
        return products;
    }
}
