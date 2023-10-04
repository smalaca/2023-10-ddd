package com.smalaca.order.domain.deliverymethod;

import com.google.common.collect.ImmutableList;
import com.smalaca.annotation.ddd.Factory;
import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public class DeliveryMethod {
    private static final ImmutableList<String> SUPPORTED = ImmutableList.of("INPOST", "POST", "DPD");

    private final String value;

    private DeliveryMethod(String value) {
        this.value = value;
    }

    @Factory
    public static DeliveryMethod deliveryMethod(String value) {
        if (isNotSupported(value)) {
            throw new DeliveryMethodException(value);
        }
        return new DeliveryMethod(value);
    }

    private static boolean isNotSupported(String value) {
        return SUPPORTED.contains(value);
    }
}
