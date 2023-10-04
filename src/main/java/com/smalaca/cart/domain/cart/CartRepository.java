package com.smalaca.cart.domain.cart;

import com.smalaca.annotation.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
public interface CartRepository {
    Cart findById(UUID cartId);

    void save(Cart cart);
}
