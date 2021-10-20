package onlineShop.models.products;

import onlineShop.models.products.peripherals.BasePeripheral;

public class Peripheral extends BasePeripheral {
    public Peripheral(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance, connectionType);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}