package com.learning.licensing.service;

import com.learning.licensing.dto.LicenseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LicenseDtoServiceTest {

    @Autowired
    private LicenseService licenseService;


    @Test
    void shouldGetLicense() {
        //given
        final LicenseDto expectedLicenseDto = provideLicense();

        //when
        final LicenseDto actualResult = licenseService.getLicense("123");

        //then
        assertEquals(expectedLicenseDto, actualResult);

    }

    private LicenseDto provideLicense() {
        return new LicenseDto.Builder()
                .organizationId("qwer-1234")
                .licenseType("Test Product Name")
                .productName("PerSeat")
                .id("123")
                .build();
    }
}