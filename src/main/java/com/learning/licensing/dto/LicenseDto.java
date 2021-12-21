package com.learning.licensing.dto;

import java.util.Objects;

public class LicenseDto {
    private final String id;
    private final String organizationId;
    private final String productName;
    private final String licenseType;

    public static class Builder {
        private String id;
        private String organizationId;
        private String productName;
        private String licenseType;

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder organizationId(String val) {
            organizationId = val;
            return this;
        }

        public Builder productName(String val) {
            productName = val;
            return this;

        }

        public Builder licenseType(String val) {
            licenseType = val;
            return this;
        }

        public LicenseDto build() {
            return new LicenseDto(this);
        }
    }

    public LicenseDto(Builder builder) {
        id = builder.id;
        organizationId = builder.organizationId;
        productName = builder.productName;
        licenseType = builder.licenseType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        var license = (LicenseDto) o;

        if (!id.equals(license.id)) return false;
        if (!Objects.equals(organizationId, license.organizationId))
            return false;
        if (!Objects.equals(productName, license.productName)) return false;
        return Objects.equals(licenseType, license.licenseType);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (organizationId != null ? organizationId.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (licenseType != null ? licenseType.hashCode() : 0);
        return result;
    }
}
