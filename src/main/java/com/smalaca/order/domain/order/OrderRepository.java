package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
public interface OrderRepository {
    void save(Order order);

    Order findById(UUID orderId);
}
