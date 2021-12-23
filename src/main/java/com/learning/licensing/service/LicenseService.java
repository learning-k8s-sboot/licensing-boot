package com.learning.licensing.service;

import com.learning.licensing.dto.LicenseDto;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {
    private final OrganizationDiscoveryClient organizationDiscoveryClient;

    public LicenseService(final OrganizationDiscoveryClient organizationDiscoveryClient) {
        this.organizationDiscoveryClient = organizationDiscoveryClient;
    }

    public LicenseDto getLicense(final String licenseId, final String organisationId) {
        return new LicenseDto.Builder()
                .id(licenseId)
                .organizationId(organizationDiscoveryClient.getOrganization(organisationId).getId())
                .licenseType("Test Product Name")
                .productName("PerSeat")
                .build();
    }
}
