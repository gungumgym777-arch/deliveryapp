package com.delivery_post.model;

import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request model for delivery cost calculation")
public record DeliveryRequest(

        @Schema(description = "Distance in kilometers", example = "150.5", minimum = "1", maximum = "5000")
        @Min(1)
        @Max(5000)
        double distanceKm,

        @Schema(description = "Weight in tons", example = "2.5", minimum = "0.1", maximum = "120")
        @DecimalMin("0.1")
        @DecimalMax("120")
        double weightTon,

        @Schema(description = "Type of cargo", example = "FRAGILE")
        @NotNull
        CargoType cargoType,


        @Schema(description = "Whether the delivery is urgent", example = "true")
        boolean isUrgent
) {
}
