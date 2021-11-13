package com.learning.licensing.service;

import com.learning.licensing.dto.License;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LicenseServiceTest {

    @Autowired
    private LicenseService licenseService;


    @Test
    void shouldGetLicense() {
        //given
        final License expectedLicense = provideLicense();

        //when
        final License actualResult = licenseService.getLicense("123");

        //then
        assertEquals(expectedLicense, actualResult);

    }

    private License provideLicense() {
        return new License.Builder()
                .organizationId("qwer-1234")
                .licenseType("Test Product Name")
                .productName("PerSeat")
                .id("123")
                .build();
    }
}