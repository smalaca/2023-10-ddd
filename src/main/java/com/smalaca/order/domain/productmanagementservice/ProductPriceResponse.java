package com.smalaca.order.domain.productmanagementservice;

import com.smalaca.order.domain.price.Price;

import java.util.Map;
import java.util.UUID;

public record ProductPriceResponse(Map<UUID, Price> prices) {
    public Price priceFor(UUID productId) {
        return prices.get(productId);
    }
}
