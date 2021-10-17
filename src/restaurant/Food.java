package restaurant;

import java.math.BigDecimal;

public class Food extends Product {
    private double grams;


    public Food(String name, BigDecimal price, double grams) {
        super(name, price);
        this.setGrams(grams);
    }

    public double getGrams() {
        return this.grams;
    }

    protected void setGrams(double grams) {
        this.grams = grams;
    }
}
