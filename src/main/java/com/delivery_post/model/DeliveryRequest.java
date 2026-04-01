package com.delivery_post.model;

import jakarta.validation.constraints.*;

public record DeliveryRequest(

        @Min(1)
        @Max(5000)
        double distanceKm,

        @DecimalMin("0.1")
        @DecimalMax("120")
        double weighTon,

        @NotNull
        CargoType cargoType,

        boolean isUrgent
) {
}
