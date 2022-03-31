package car.insurance.premium.model;

import static car.insurance.premium.common.CarPremiumConstant.CAR_TYPE_ERROR_LABEL;

public enum CarType {
    UNKNOWN,
    SEDAN,
    SUV,
    HATCHBACK;

    public static CarType from(String value) {
        final CarType[] availableCarTypes = values();
        for (CarType availableCarType : availableCarTypes) {
            if (availableCarType.name().equalsIgnoreCase(value)
                    && !value.equalsIgnoreCase(UNKNOWN.name())) {
                return availableCarType;
            }
        }
        throw new IllegalArgumentException(CAR_TYPE_ERROR_LABEL);
    }
}
