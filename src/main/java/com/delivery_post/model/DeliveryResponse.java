package com.delivery_post.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response model for delivery cost calculation")
public record DeliveryResponse(

        @Schema(description = "Base price for the delivery", example = "1500.0")
        double basePrice,

        @Schema(description = "Surcharge for urgent deliveries", example = "200.0")
        double urgentSurcharge,
        
        @Schema(description = "Surcharge for specific cargo types", example = "150.0")
        double cargoTypeSurcharge,
        
        @Schema(description = "Total price for the delivery", example = "1850.0")
        double totalPrice,
        
        @Schema(description = "Currency for the prices", example = "KZT")
        String currency
) {
}
