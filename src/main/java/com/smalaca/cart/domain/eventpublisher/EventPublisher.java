package com.smalaca.cart.domain.eventpublisher;

import com.smalaca.cart.domain.cart.ProductsRemovedFromCartEvent;

public interface EventPublisher {
    void publish(ProductsRemovedFromCartEvent event);
}
