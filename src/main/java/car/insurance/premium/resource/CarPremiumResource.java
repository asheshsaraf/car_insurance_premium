package car.insurance.premium.resource;

import car.insurance.premium.service.CarPremiumService;
import car.insurance.premium.model.CarDetail;
import car.insurance.premium.model.CarPremium;
import car.insurance.premium.model.CarType;
import car.insurance.premium.model.InsuranceType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static car.insurance.premium.common.CarPremiumConstant.*;

public final class CarPremiumResource {

    private final CarPremiumService carPremiumService;

    public CarPremiumResource(final CarPremiumService carPremiumService) {
        this.carPremiumService = carPremiumService;
    }

    public List<CarPremium> loadResourceAndCalculatePremium() {
        return getCarDetailsFromUser()
                .stream()
                .map(carPremiumService::calculatePremium)
                .toList();
    }

    private List<CarDetail> getCarDetailsFromUser() {
        final Scanner scanner = new Scanner(System.in);
        final List<CarDetail> carDetails = new ArrayList<>();
        boolean continueWithCarDetails = true;
        while (continueWithCarDetails) {
            carDetails.add(getCarDetail(scanner));
            continueWithCarDetails = isContinueWithCarDetails(scanner);
        }
        scanner.close();
        return carDetails;
    }

    private CarDetail getCarDetail(Scanner scanner) {
        return new CarDetail(getCarModel(scanner),
                getCarType(scanner),
                getCarPrice(scanner),
                getInsuranceType(scanner));
    }

    private String getCarModel(Scanner scanner) {
        System.out.print(CAR_MODEL_LABEL);
        return scanner.next();
    }

    private CarType getCarType(Scanner scanner) {
        System.out.print(CAR_TYPE_LABEL);
        final String carType = scanner.next();
        try {
            return CarType.from(carType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getCarType(scanner);
        }
        return CarType.UNKNOWN;
    }

    private Double getCarPrice(Scanner scanner) {
        System.out.print(CAR_COST_PRICE_LABEL);
        final String carPrice = scanner.next();
        try {
            return Double.parseDouble(carPrice);
        } catch (Exception e) {
            System.out.println(CAR_COST_PRICE_ERROR_LABEL);
            getCarType(scanner);
        }
        return Double.NaN;
    }

    private InsuranceType getInsuranceType(Scanner scanner) {
        System.out.print(INSURANCE_TYPE_LABEL);
        final String insuranceType = scanner.next();
        try {
            return InsuranceType.from(insuranceType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getInsuranceType(scanner);
        }
        return InsuranceType.UNKNOWN;
    }

    private boolean isContinueWithCarDetails(Scanner scanner) {
        System.out.print(OTHER_CAR_DETAIL_LABEL);
        final String carDetailsNeeded = scanner.next();
        if (Y_INPUT.equalsIgnoreCase(carDetailsNeeded)
                || YES_INPUT.equalsIgnoreCase(carDetailsNeeded)) {
            return true;
        } else if (N_INPUT.equalsIgnoreCase(carDetailsNeeded)
                || NO_INPUT.equalsIgnoreCase(carDetailsNeeded)) {
            return false;
        } else {
            System.out.println(OTHER_CAR_DETAIL_ERROR_LABEL);
            isContinueWithCarDetails(scanner);
        }
        return false;
    }

}
