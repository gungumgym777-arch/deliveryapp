package com.delivery_post.service;

import com.delivery_post.model.DeliveryRequest;
import com.delivery_post.model.DeliveryResponse;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    public DeliveryResponse calculate(DeliveryRequest request) {

        double basePrice = request.distanceKm() * request.weightTon() * 8;
        double urgentSurcharge = request.isUrgent() ? basePrice * 0.2 : 0;

        double cargoTypeSurcharge = switch (request.cargoType()) {
            case FRAGILE -> basePrice * 0.1;
            case OVERSIZED -> basePrice * 0.25;
            case STANDARD -> 0;
        };

        double totalPrice = basePrice + urgentSurcharge + cargoTypeSurcharge;

        return new DeliveryResponse(
                basePrice,
                urgentSurcharge,
                cargoTypeSurcharge,
                totalPrice,
                "KZT"
        );
    }
}
