package onlineShop.models.products;

import onlineShop.models.products.components.BaseComponent;

public class Component extends BaseComponent {
    public Component(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance, generation);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
