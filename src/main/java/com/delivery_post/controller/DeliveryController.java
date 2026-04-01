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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/delivery")
public class DeliveryController {

    private final DeliveryService service;

    @PostMapping("/calculate")
    public DeliveryResponse calculate(@Valid @RequestBody DeliveryRequest request) {

        return  service.calculate(request);
    }
}
