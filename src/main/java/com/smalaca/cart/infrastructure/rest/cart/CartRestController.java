package com.smalaca.cart.infrastructure.rest.cart;

import com.smalaca.cart.application.cart.CartApplicationService;
import com.smalaca.cart.query.cart.CartDetails;
import com.smalaca.cart.query.cart.CartQueryFacade;

import java.util.Map;
import java.util.UUID;

public class CartRestController {
    private final CartQueryFacade cartQueryFacade;
    private final CartApplicationService cartApplicationService;

    public CartRestController(CartQueryFacade cartQueryFacade, CartApplicationService cartApplicationService) {
        this.cartQueryFacade = cartQueryFacade;
        this.cartApplicationService = cartApplicationService;
    }

    public CartDetails findById(UUID cartId) {
        return cartQueryFacade.findById(cartId);
    }

    public void addProducts(UUID cartId, Map<UUID, Integer> products) {
        cartApplicationService.addProducts(cartId, products);
    }
}
