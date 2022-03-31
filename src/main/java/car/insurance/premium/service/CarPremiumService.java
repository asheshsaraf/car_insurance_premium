package car.insurance.premium.service;

import car.insurance.premium.model.CarDetail;
import car.insurance.premium.model.CarPremium;
import car.insurance.premium.model.CarType;
import car.insurance.premium.model.InsuranceType;

import static car.insurance.premium.common.CarPremiumConstant.*;

public final class CarPremiumService {

    public CarPremium calculatePremium(CarDetail carDetail) {
        return new CarPremium(carDetail.getModel(), carDetail.getPrice(), getCarPremium(carDetail));
    }

    private Double getCarPremium(CarDetail carDetail) {
        Double carPremium = carDetail.getPrice() * getPercentageForCarType(carDetail.getType());
        carPremium = getUpdatedPremium(carDetail.getInsuranceType(), carPremium);
        return carPremium;
    }

    private Double getPercentageForCarType(CarType type) {
        return switch (type) {
            case UNKNOWN -> UNKNOWN_TYPE_PREMIUM_PERCENTAGE;
            case HATCHBACK -> HATCHBACK_TYPE_PREMIUM_PERCENTAGE;
            case SEDAN -> SEDAN_TYPE_PREMIUM_PERCENTAGE;
            case SUV -> SUV_TYPE_PREMIUM_PERCENTAGE;
        };
    }

    private Double getUpdatedPremium(InsuranceType insuranceType, Double carPremium) {
        if (insuranceType == InsuranceType.PREMIUM) {
            carPremium += (PREMIUM_PERCENTAGE * carPremium);
        }
        return carPremium;
    }

}
