package com.ex.dm.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/bookings")
//@RequiredArgsConstructor
public class BookingController {

    private final RestTemplate restTemplate;

    public BookingController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public String bookTicket(@RequestBody Map<String, Object> request) {
        // 1. Create booking
        String bookingId = UUID.randomUUID().toString();

        // 2. Call Payment Service
        String paymentResponse = restTemplate.postForObject(
              "http://payment-service/api/payments",
                Map.of("bookingId", bookingId, "amount", request.get("amount")),
              String.class
        );

        // 3. Call Notification Service
        restTemplate.postForObject(
                "http://notification-service/api/notify",
                Map.of("bookingId", bookingId, "message", "Booking confirmed!"),
                String.class
        );
	//String paymentResponse = "Success";

        return "Booking Successful! ID: " + bookingId + " | " + paymentResponse;
    }
}

