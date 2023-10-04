package com.smalaca.order.domain.productmanagementservice;

import java.util.Set;
import java.util.UUID;

public interface ProductManagementService {
    ProductPriceResponse priceFor(Set<UUID> productIds);
}
