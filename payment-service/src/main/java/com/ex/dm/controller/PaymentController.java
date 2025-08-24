package com.ex.dm.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @PostMapping
    public String makePayment(@RequestBody Map<String, Object> payment) {
        return "Payment Success for Booking ID: " + payment.get("bookingId");
    }
}

