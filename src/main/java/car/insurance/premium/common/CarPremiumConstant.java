package car.insurance.premium.common;

public final class CarPremiumConstant {

    public static final String CAR_MODEL_LABEL = "Enter Car Model: ";
    public static final String CAR_TYPE_LABEL = "Enter Car Type: ";
    public static final String CAR_COST_PRICE_LABEL = "Enter Car Cost Price: ";
    public static final String INSURANCE_TYPE_LABEL = "Enter Insurance Type: ";
    public static final String OTHER_CAR_DETAIL_LABEL = "Do you want to enter details of any other car (y/n): ";

    public static final String CAR_TYPE_ERROR_LABEL = "Invalid car type.";
    public static final String INSURANCE_TYPE_ERROR_LABEL = "Invalid insurance type.";
    public static final String CAR_COST_PRICE_ERROR_LABEL = "Invalid Car Cost Price";
    public static final String OTHER_CAR_DETAIL_ERROR_LABEL = "Invalid input.";

    public static final String Y_INPUT = "Y";
    public static final String YES_INPUT = "YES";
    public static final String N_INPUT = "N";
    public static final String NO_INPUT = "NO";

    public static final double UNKNOWN_TYPE_PREMIUM_PERCENTAGE = 0.0;
    public static final double HATCHBACK_TYPE_PREMIUM_PERCENTAGE = 0.05;
    public static final double SEDAN_TYPE_PREMIUM_PERCENTAGE = 0.08;
    public static final double SUV_TYPE_PREMIUM_PERCENTAGE = 0.1;
    public static final double PREMIUM_PERCENTAGE = 0.2;

    private CarPremiumConstant() {
    }

}
