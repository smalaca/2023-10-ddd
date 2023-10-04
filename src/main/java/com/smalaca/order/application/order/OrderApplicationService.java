package com.smalaca.order.application.order;

import com.smalaca.order.domain.order.DeliveryMethod;
import com.smalaca.order.domain.order.Order;
import com.smalaca.order.domain.order.OrderFactory;
import com.smalaca.order.domain.order.OrderRepository;

import java.util.UUID;

public class OrderApplicationService {
    private final OrderRepository orderRepository;
    private final OrderFactory orderFactory;

    public OrderApplicationService(OrderRepository orderRepository, OrderFactory orderFactory) {
        this.orderRepository = orderRepository;
        this.orderFactory = orderFactory;
    }

    public void acceptCart(UUID cartId, String deliveryMethod) {
        DeliveryMethod deliveryMethodVO = DeliveryMethod.deliveryMethod(deliveryMethod);

        Order order = orderFactory.create(cartId, deliveryMethodVO);

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
