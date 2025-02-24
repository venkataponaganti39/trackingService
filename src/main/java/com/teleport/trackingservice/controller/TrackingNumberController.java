package com.teleport.trackingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teleport.trackingservice.model.TrackingNumberResponse;
import com.teleport.trackingservice.service.TrackingNumberService;

@RestController
public class TrackingNumberController {

    @Autowired
    private TrackingNumberService trackingNumberService;

    @GetMapping("/next-tracking-number")
    public TrackingNumberResponse getNextTrackingNumber(
            @RequestParam String origin_country_id,
            @RequestParam String destination_country_id,
            @RequestParam double weight,
            @RequestParam String created_at,
            @RequestParam String customer_id,
            @RequestParam String customer_name,
            @RequestParam String customer_slug) {

        return trackingNumberService.generateTrackingNumber(
                origin_country_id, destination_country_id, weight, created_at,
                customer_id, customer_name, customer_slug);
    }
}
