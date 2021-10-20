package onlineShop.models.products.components;

import onlineShop.models.products.Component;

public class RandomAccessMemory extends Component {
    private static final double OVERALL_PERFORMANCE_MULTIPLIER = 1.20;

    public RandomAccessMemory(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price
                , overallPerformance * OVERALL_PERFORMANCE_MULTIPLIER, generation);
    }
}