package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.DomainRepository;

@DomainRepository
public interface OrderRepository {
    void save(Order order);
}
