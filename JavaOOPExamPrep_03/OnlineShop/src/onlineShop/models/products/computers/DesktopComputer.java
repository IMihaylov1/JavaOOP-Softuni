package onlineShop.models.products.computers;

import onlineShop.models.products.Computer;

public class DesktopComputer extends Computer {
    private static final double OVERALL_PERFORMANCE = 15;

    public DesktopComputer(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, OVERALL_PERFORMANCE);
    }
}