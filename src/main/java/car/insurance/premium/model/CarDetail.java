package car.insurance.premium.model;

public class CarDetail {

    private final String model;
    private final CarType type;
    private final Double price;
    private final InsuranceType insuranceType;

    public CarDetail(String model,
                     CarType type,
                     Double price,
                     InsuranceType insuranceType) {
        this.model = model;
        this.type = type;
        this.price = price;
        this.insuranceType = insuranceType;
    }

    public String getModel() {
        return model;
    }

    public CarType getType() {
        return type;
    }

    public Double getPrice() {
        return price;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }
}
