package com.smalaca.order.domain.deliveryservice;

import com.smalaca.order.domain.order.Address;
import com.smalaca.order.domain.order.DeliveryMethod;
import com.smalaca.order.domain.price.Price;

public interface DeliveryService {
    Price priceForDelivery(DeliveryMethod deliveryMethod, Address address);
}
