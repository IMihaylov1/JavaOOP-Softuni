package onlineShop.models.products.peripherals;

import onlineShop.models.products.Peripheral;

public class Mouse extends Peripheral {
    public Mouse(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance, connectionType);
    }
}
