package com.learning.licensing.service;

import com.learning.licensing.dto.License;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LicenseService {
    public License getLicense(String licenseId) {
        for (int i = 0; i < 100; i++) {
            System.out.println("Count #" + i);
        }

        return new License.Builder()
                .id(licenseId)
                .organizationId("qwer-1234")
                .licenseType("Test Product Name")
                .productName("PerSeat")
                .build();
    }
}
