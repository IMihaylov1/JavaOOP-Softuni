package onlineShop.models.products;

import onlineShop.models.products.computers.BaseComputer;

public class Computer extends BaseComputer {
    public Computer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
    }
}
