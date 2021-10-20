package onlineShop.models.products.computers;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public double getOverallPerformance() {
        if (components.isEmpty()) {
            return super.getOverallPerformance();
        }
        return super.getOverallPerformance() + getComponentAverageOverallPerformance();
    }

    @Override
    public double getPrice() {
        return super.getPrice() + getAllPricesInComponentsAndPeripherals();
    }

    @Override
    public void addComponent(Component component) {
        for (Component component1 : components) {
            if (component1.equals(component)) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_COMPONENT
                        , component, this.getClass(), super.getId()));
            }
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        if (this.components.isEmpty() || !containsComponent(componentType)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_COMPONENT
                    , componentType, this.getClass(), super.getId()));
        }

        int index = -1;
        for (int i = 0; i < this.components.size(); i++) {
            if (this.components.get(i).getClass().getSimpleName().equals(componentType)) {
                index = i;
                break;
            }
        }
        return this.components.remove(index);
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        for (Peripheral peripheral1 : peripherals) {
            if (peripheral1.equals(peripheral)) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_PERIPHERAL
                        , peripheral, this.getClass(), super.getId()));
            }
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        if (this.peripherals.isEmpty() || !containsPeripherals(peripheralType)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_PERIPHERAL
                    , peripheralType, this.getClass(), super.getId()));
        }

        int index = -1;
        for (int i = 0; i < this.peripherals.size(); i++) {
            if (this.peripherals.get(i).getClass().getSimpleName().equals(peripheralType)) {
                index = i;
                break;
            }
        }
        return this.peripherals.remove(index);
    }

    private boolean containsPeripherals(String peripheralsName) {
        for (Peripheral peripheral : peripherals) {
            String simpleName = peripheral.getClass().getSimpleName();
            if (simpleName.equals(peripheralsName)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsComponent(String componentName) {
        for (Component component : components) {
            String simpleName = component.getClass().getSimpleName();
            if (simpleName.equals(componentName)) {
                return true;
            }
        }
        return false;
    }

    private double getAllPricesInComponentsAndPeripherals() {
        double totalPrice = 0.0;

        for (Component component : components) {
            totalPrice += component.getPrice();
        }
        for (Peripheral peripheral : peripherals) {
            totalPrice += peripheral.getPrice();
        }
        return totalPrice;
    }

    private double getComponentAverageOverallPerformance() {
        double sum = 0.0;

        for (Component component : components) {
            sum += component.getOverallPerformance();
        }
        if (sum > 0.0){
            return sum / this.components.size();
        }
        return 0.0;
    }

    private double getAveragePeripheralsOverallPerformance(){
        double sum = 0.0;

        for (Peripheral peripheral : peripherals) {
            sum += peripheral.getOverallPerformance();
        }
        if (sum > 0.0){
            return sum / this.peripherals.size();
        }
        return 0.0;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(OutputMessages.PRODUCT_TO_STRING
                ,getOverallPerformance(), getPrice(), this.getClass().getSimpleName(), getManufacturer(), getModel(), getId()))
                .append(System.lineSeparator());
        stringBuilder.append(String.format(" " + OutputMessages.COMPUTER_COMPONENTS_TO_STRING, components.size()))
                .append(System.lineSeparator());
        for (Component component : components) {
            stringBuilder.append("  ").append(component.toString()).append(System.lineSeparator());
        }
        stringBuilder.append(String.format(" " + OutputMessages.COMPUTER_PERIPHERALS_TO_STRING, peripherals.size(), getAveragePeripheralsOverallPerformance()))
                .append(System.lineSeparator());
        for (Peripheral peripheral : peripherals) {
            stringBuilder.append("  ").append(peripheral.toString()).append(System.lineSeparator());
        }


        return stringBuilder.toString().trim();
    }
}