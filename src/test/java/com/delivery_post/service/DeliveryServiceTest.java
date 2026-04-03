package com.delivery_post.service;

import com.delivery_post.model.CargoType;
import com.delivery_post.model.DeliveryRequest;
import com.delivery_post.model.DeliveryResponse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeliveryServiceTest {

    private final DeliveryService deliveryService = new DeliveryService();

    @Test
    void testCalculateStandardCargoNonUrgent() {
        // Given
        DeliveryRequest request = new DeliveryRequest(100.0, 1.0, CargoType.STANDARD, false);

        // When
        DeliveryResponse response = deliveryService.calculate(request);

        // Then
        assertEquals(800.0, response.basePrice()); // 100 * 1 * 8
        assertEquals(0.0, response.urgentSurcharge());
        assertEquals(0.0, response.cargoTypeSurcharge());
        assertEquals(800.0, response.totalPrice());
        assertEquals("KZT", response.currency());
    }

    @Test
    void testCalculateFragileCargoNonUrgent() {
        // Given
        DeliveryRequest request = new DeliveryRequest(100.0, 1.0, CargoType.FRAGILE, false);

        // When
        DeliveryResponse response = deliveryService.calculate(request);

        // Then
        assertEquals(800.0, response.basePrice()); // 100 * 1 * 8
        assertEquals(0.0, response.urgentSurcharge());
        assertEquals(80.0, response.cargoTypeSurcharge()); // 800 * 0.1
        assertEquals(880.0, response.totalPrice());
        assertEquals("KZT", response.currency());
    }

    @Test
    void testCalculateOversizedCargoNonUrgent() {
        // Given
        DeliveryRequest request = new DeliveryRequest(100.0, 1.0, CargoType.OVERSIZED, false);

        // When
        DeliveryResponse response = deliveryService.calculate(request);

        // Then
        assertEquals(800.0, response.basePrice()); // 100 * 1 * 8
        assertEquals(0.0, response.urgentSurcharge());
        assertEquals(200.0, response.cargoTypeSurcharge()); // 800 * 0.25
        assertEquals(1000.0, response.totalPrice());
        assertEquals("KZT", response.currency());
    }

    @Test
    void testCalculateStandardCargoUrgent() {
        // Given
        DeliveryRequest request = new DeliveryRequest(100.0, 1.0, CargoType.STANDARD, true);

        // When
        DeliveryResponse response = deliveryService.calculate(request);

        // Then
        assertEquals(800.0, response.basePrice()); // 100 * 1 * 8
        assertEquals(160.0, response.urgentSurcharge()); // 800 * 0.2
        assertEquals(0.0, response.cargoTypeSurcharge());
        assertEquals(960.0, response.totalPrice());
        assertEquals("KZT", response.currency());
    }

    @Test
    void testCalculateFragileCargoUrgent() {
        // Given
        DeliveryRequest request = new DeliveryRequest(50.0, 2.0, CargoType.FRAGILE, true);

        // When
        DeliveryResponse response = deliveryService.calculate(request);

        // Then
        assertEquals(800.0, response.basePrice()); // 50 * 2 * 8
        assertEquals(160.0, response.urgentSurcharge()); // 800 * 0.2
        assertEquals(80.0, response.cargoTypeSurcharge()); // 800 * 0.1
        assertEquals(1040.0, response.totalPrice());
        assertEquals("KZT", response.currency());
    }

    @Test
    void testCalculateOversizedCargoUrgent() {
        // Given
        DeliveryRequest request = new DeliveryRequest(200.0, 0.5, CargoType.OVERSIZED, true);

        // When
        DeliveryResponse response = deliveryService.calculate(request);

        // Then
        assertEquals(800.0, response.basePrice()); // 200 * 0.5 * 8
        assertEquals(160.0, response.urgentSurcharge()); // 800 * 0.2
        assertEquals(200.0, response.cargoTypeSurcharge()); // 800 * 0.25
        assertEquals(1160.0, response.totalPrice());
        assertEquals("KZT", response.currency());
    }
}