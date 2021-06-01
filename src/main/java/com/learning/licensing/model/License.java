package com.learning.licensing.model;

public class License {
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

        public License build() {
            return new License(this);
        }
    }

    public License(Builder builder) {
        id = builder.id;
        organizationId = builder.organizationId;
        productName = builder.productName;
        licenseType = builder.licenseType;
    }

    public String getId() {
        return id;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public String getProductName() {
        return productName;
    }

    public String getLicenseType() {
        return licenseType;
    }
}
