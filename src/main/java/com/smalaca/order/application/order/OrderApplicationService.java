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
        Order order = Order.create(cartId, deliveryMethodId);

        orderRepository.save(order);
    }

    public void cancel(UUID orderId) {
        Order order = orderRepository.findById(orderId);

        order.cancel();

        orderRepository.save(order);
    }

    public void complete(UUID orderId) {
        Order order = orderRepository.findById(orderId);

        order.complete();

        orderRepository.save(order);
    }

    public void resign(UUID orderId) {
        Order order = orderRepository.findById(orderId);

        order.resign();

        orderRepository.save(order);
    }
}
