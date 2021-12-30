package com.learning.licensing.service;

import com.learning.licensing.dto.OrganisationDto;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrganizationDiscoveryClient {
    private static final String ORGANISATION_URL = "http://learning-k8s-sboot-organization-boot:8080/organization-service/v1/organizations/{organizationId}";

//    private final RestTemplate restTemplate;

//    public OrganizationDiscoveryClient(final RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    public OrganisationDto getOrganization(final String organizationId) {
//        return restTemplate.exchange(ORGANISATION_URL, HttpMethod.GET, null, OrganisationDto.class, organizationId).getBody();
//    }

}
