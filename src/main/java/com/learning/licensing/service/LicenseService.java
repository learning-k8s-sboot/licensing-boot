package com.learning.licensing.service;

import com.learning.licensing.dto.License;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {
    public License getLicense(String licenseId) {
        return new License.Builder()
                .id(licenseId)
                .organizationId("qwer-1234")
                .licenseType("Test Product Name")
                .productName("PerSeat")
                .build();
    }
}
