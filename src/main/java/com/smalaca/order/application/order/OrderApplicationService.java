package com.smalaca.order.application.order;

import com.smalaca.order.domain.eventpublisher.EventPublisher;
import com.smalaca.order.domain.order.AcceptCartDomainCommand;
import com.smalaca.order.domain.order.Order;
import com.smalaca.order.domain.order.OrderFactory;
import com.smalaca.order.domain.order.OrderRepository;

import java.util.UUID;

public class OrderApplicationService {
    private final EventPublisher eventPublisher;
    private final OrderRepository orderRepository;
    private final OrderFactory orderFactory;

    public OrderApplicationService(
            EventPublisher eventPublisher, OrderRepository orderRepository, OrderFactory orderFactory) {
        this.eventPublisher = eventPublisher;
        this.orderRepository = orderRepository;
        this.orderFactory = orderFactory;
    }

    public void acceptCart(UUID buyerId, AcceptCartCommand command) {
        AcceptCartDomainCommand acceptCartCommand = command.asAcceptCartCommand(buyerId);

        Order order = orderFactory.create(acceptCartCommand, eventPublisher);

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
