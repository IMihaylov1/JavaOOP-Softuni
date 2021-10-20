package onlineShop.models.products;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;


public abstract class BaseProduct implements Product {
    private int id;
    private String manufacturer;
    private String model;
    private double price;
    private double overallPerformance;

    protected BaseProduct(int id, String manufacturer, String model, double price, double overallPerformance) {
        setId(id);
        setManufacturer(manufacturer);
        setModel(model);
        setPrice(price);
        setOverallPerformance(overallPerformance);
    }

    private void setId(int id) {
        if (validateNumericInput(id)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRODUCT_ID);
        }
        this.id = id;
    }

    private void setManufacturer(String manufacturer) {
        if (validateTextInput(manufacturer)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MANUFACTURER);
        }
        this.manufacturer = manufacturer;
    }

    private void setModel(String model) {
        if (validateTextInput(model)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MODEL);
        }
        this.model = model;
    }

    private void setPrice(double price) {
        if (validateNumericInput(price)){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
        }
        this.price = price;
    }

    private void setOverallPerformance(double overallPerformance) {
        if (validateNumericInput(overallPerformance)){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_OVERALL_PERFORMANCE);
        }
        this.overallPerformance = overallPerformance;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public double getOverallPerformance() {
        return this.overallPerformance;
    }

    private boolean validateNumericInput(int value) {
        return value <= 0;
    }

    private boolean validateNumericInput(double value) {
        return value <= 0;
    }

    private boolean validateTextInput(String text) {
        return text == null || text.trim().isEmpty();
    }

    @Override
    public String toString() {
        return String.format(OutputMessages.PRODUCT_TO_STRING
                ,this.overallPerformance, this.price, this.getClass().getSimpleName(), this.manufacturer, this.model, this.id);
    }
}