package com.learning.licensing.service;

import com.learning.licensing.dto.LicenseDto;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {
    public LicenseDto getLicense(String licenseId) {
        return new LicenseDto.Builder()
                .id(licenseId)
                .organizationId("qwer-1234")
                .licenseType("Test Product Name")
                .productName("PerSeat")
                .build();
    }
}
