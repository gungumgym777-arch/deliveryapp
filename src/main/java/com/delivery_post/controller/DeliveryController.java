package com.delivery_post.controller;

import com.delivery_post.model.DeliveryRequest;
import com.delivery_post.model.DeliveryResponse;
import com.delivery_post.service.DeliveryService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/delivery")
@Tag(name = "Delivery cost calculation", description = "Endpoints for calculating devlivery costs")
public class DeliveryController {

    private final DeliveryService service;

    @PostMapping("/calculate")
    @Operation(summary = "Calculate delivery cost")
    public DeliveryResponse calculate(@Valid @RequestBody DeliveryRequest request) {

        return  service.calculate(request);
    }
}
