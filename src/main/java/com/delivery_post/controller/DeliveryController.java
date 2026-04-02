package com.delivery_post.controller;

import com.delivery_post.model.DeliveryRequest;
import com.delivery_post.model.DeliveryResponse;
import com.delivery_post.service.DeliveryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Parameter;
import io.swagger.v3.oas.annotations.tags.media.Content;
import io.swagger.v3.oas.annotations.tags.media.Schema;
import io.swagger.v3.oas.annotations.tags.mdeia.ExampleObject;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/delivery")
@Tag(name = "Delivery cost calculation", description = "Endpoints for calculating devlivery costs")
public class DeliveryController {

    private final DeliveryService service;

    @PostMapping("/calculate")
    public DeliveryResponse calculate(@Valid @RequestBody DeliveryRequest request) {

        return  service.calculate(request);
    }
}
