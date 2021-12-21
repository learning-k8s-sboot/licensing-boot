package com.learning.licensing.controller;

import com.learning.licensing.dto.LicenseDto;
import com.learning.licensing.service.LicenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/organizations/123456789/licenses")
public class LicenseController {

    private final LicenseService licenseService;

    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @GetMapping(value = "/{licenseId}")
    public ResponseEntity<LicenseDto> getLicenses(@PathVariable("licenseId") String licenseId) {
        return ResponseEntity.ok(licenseService.getLicense(licenseId));
    }
}
