package car.insurance.premium.model;

public class CarPremium {

    private final String model;
    private final Double price;
    private final Double premium;

    public CarPremium(String model,
                      Double price,
                      Double premium) {
        this.model = model;
        this.price = price;
        this.premium = premium;
    }

    public String getModel() {
        return model;
    }

    public Double getPrice() {
        return price;
    }

    public Double getPremium() {
        return premium;
    }

    @Override
    public String toString() {
        return "Car Model: " + getModel() + "\n" +
                "Car Cost Price: " + getPrice().toString() + "\n" +
                "Total Premium: " + getPremium().toString() + "\n";
    }

}
