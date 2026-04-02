package com.delivery_post.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Type of cargo for delivery", example = "FRAGILE", allowableValues = {"FRAGILE", "OVERSIZED", "STANDARD"})
public enum CargoType {

    @Schema(description = "Fragile cargo that requires special handling", example = "FRAGILE")
    @JsonProperty("FRAGILE")
    FRAGILE,

    @Schema(description = "Oversized cargo that exceeds standard dimensions", example = "OVERSIZED")
    @JsonProperty("OVERSIZED")  
    OVERSIZED,

    @Schema(description = "Standard cargo with typical dimensions", example = "STANDARD")
    @JsonProperty("STANDARD")
    STANDARD
}
