package com.smalaca.order.application.order;

import com.smalaca.order.domain.order.Order;
import com.smalaca.order.domain.order.OrderRepository;

import java.util.UUID;

public class OrderApplicationService {
    private final OrderRepository orderRepository;

    public OrderApplicationService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void acceptCart(UUID cartId, UUID deliveryMethodId) {
        Order order = new Order(cartId, deliveryMethodId);

        orderRepository.save(order);
    }
}
