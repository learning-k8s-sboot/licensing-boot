package com.learning.licensing.service;

import com.learning.licensing.model.License;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LicenseService {
    public License getLicense(String licenseId) {
    return new License.Builder()
            .id(licenseId)
            .organizationId(UUID.randomUUID().toString())
            .licenseType("Test Product Name")
            .productName("PerSeat")
            .build();
    }
}
