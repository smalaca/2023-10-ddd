package com.smalaca.order.domain.deliveryservice;

import com.smalaca.order.domain.address.Address;
import com.smalaca.order.domain.deliverymethod.DeliveryMethod;
import com.smalaca.order.domain.price.Price;

public interface DeliveryService {
    Price priceForDelivery(DeliveryMethod deliveryMethod, Address address);
}
