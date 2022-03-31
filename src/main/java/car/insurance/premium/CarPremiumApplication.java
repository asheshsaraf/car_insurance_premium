package car.insurance.premium;

import car.insurance.premium.resource.CarPremiumResource;
import car.insurance.premium.service.CarPremiumService;

public class CarPremiumApplication {

    private final CarPremiumResource carPremiumResource;

    public CarPremiumApplication() {
        this.carPremiumResource = new CarPremiumResource(new CarPremiumService());
    }

    public static void main(String[] args) {
        new CarPremiumApplication().run();
    }

    public void run() {
        carPremiumResource.loadResourceAndCalculatePremium()
                .forEach(System.out::println);
    }

}
