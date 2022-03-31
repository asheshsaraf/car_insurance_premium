package car.insurance.premium.model;

import static car.insurance.premium.common.CarPremiumConstant.INSURANCE_TYPE_ERROR_LABEL;

public enum InsuranceType {
    UNKNOWN,
    BASIC,
    PREMIUM;

    public static InsuranceType from(String value) {
        final InsuranceType[] availableInsuranceTypes = values();
        for (InsuranceType insuranceType : availableInsuranceTypes) {
            if (insuranceType.name().equalsIgnoreCase(value)
                    && !value.equalsIgnoreCase(UNKNOWN.name())) {
                return insuranceType;
            }
        }
        throw new IllegalArgumentException(INSURANCE_TYPE_ERROR_LABEL);
    }
}
