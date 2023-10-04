package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
class Address {
    private final String street;
    private final String postalCode;
    private final String city;
    private final String country;

    Address(String street, String postalCode, String city, String country) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }
}
