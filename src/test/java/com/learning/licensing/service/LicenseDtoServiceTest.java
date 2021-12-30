package com.learning.licensing.service;

import com.learning.licensing.dto.LicenseDto;
import com.learning.licensing.dto.OrganisationDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LicenseDtoServiceTest {

    @InjectMocks
    private LicenseService licenseService;

    @Mock
    private OrganizationDiscoveryClient organizationDiscoveryClient;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldGetLicense() {
        //given
//        Mockito.when(organizationDiscoveryClient.getOrganization(Mockito.anyString())).thenReturn(provideOrganization());

        //when
        final LicenseDto actualResult = licenseService.getLicense("123", "987");

        //then
        assertEquals(provideLicense(), actualResult);
    }

    private OrganisationDto provideOrganization() {
        final OrganisationDto organisationDto = new OrganisationDto();
        organisationDto.setId("987");
        return organisationDto;
    }

    private LicenseDto provideLicense() {
        return new LicenseDto.Builder()
                .organizationId("987")
                .licenseType("Test Product Name")
                .productName("PerSeat")
                .id("123")
                .build();
    }
}