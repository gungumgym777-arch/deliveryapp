package com.delivery_post.model;

public record DeliveryResponse(
        double basePrice,
        double urgentSurcharge,
        double cargoTypeSurcharge,
        double totalPrice,
        String currency
) {
}
