package com.teleport.trackingservice.service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teleport.trackingservice.model.TrackingNumber;
import com.teleport.trackingservice.model.TrackingNumberResponse;
import com.teleport.trackingservice.repository.TrackingNumberRepository;

@Service
public class TrackingNumberService {

    @Autowired
    private TrackingNumberRepository trackingNumberRepository;
    
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int MAX_LENGTH = 16;
    private final SecureRandom random = new SecureRandom();

    // Helper method to generate unique tracking number
    public synchronized TrackingNumberResponse generateTrackingNumber(String originCountryId, String destinationCountryId,
                                                      double weight, String createdAt, String customerId,
                                                      String customerName, String customerSlug) {
        
        String trackingNumber = generateHash();

        // Ensure uniqueness by checking the database
        while (trackingNumberRepository.existsByTrackingNumber(trackingNumber)) {
            trackingNumber = generateHash();
        }

        // Save the tracking number to the database
        TrackingNumber trackingNumberEntity = new TrackingNumber();
        trackingNumberEntity.setTrackingNumber(trackingNumber);
        trackingNumberEntity.setOriginCountryId(originCountryId);
        trackingNumberEntity.setDestinationCountryId(destinationCountryId);
        trackingNumberEntity.setWeight(weight);
        trackingNumberEntity.setCreatedAt(createdAt);
        trackingNumberEntity.setCustomerId(customerId);
        trackingNumberEntity.setCustomerName(customerName);
        trackingNumberEntity.setCustomerSlug(customerSlug);
        trackingNumberEntity.setGeneratedAt(java.time.OffsetDateTime.now());

        trackingNumberRepository.save(trackingNumberEntity);

        return new TrackingNumberResponse(trackingNumberEntity.getTrackingNumber(),trackingNumberEntity.getGeneratedAt().toString());
    }

    private String generateHash() {
        // Generate a hash of the base and return a substring to ensure it's within the regex length
       // return Integer.toHexString(base.hashCode()).toUpperCase().substring(0, 16);
        StringBuilder trackingNumber = new StringBuilder(MAX_LENGTH);
        for (int i = 0; i < MAX_LENGTH; i++) {
            trackingNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return trackingNumber.toString();
    }
}
