package onlineShop.core.interfaces;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.models.products.Computer;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {
   private List<Computer> computerList;

    public ControllerImpl() {
        this.computerList = new ArrayList<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        Computer computer = createComputer(computerType, id, manufacturer, model, price);
        for (Computer currentComputer : computerList) {
            if (computer.getId() == currentComputer.getId()) {
                throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
            }
        }
        this.computerList.add(computer);

        return String.format(OutputMessages.ADDED_COMPUTER, computer.getId());
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        Peripheral peripheral = createPeripheral(id, peripheralType, manufacturer, model, price, overallPerformance);
        Computer computer = getComputer(computerId);

        putPeripheralToComputer(peripheral, computer);
        return String.format(OutputMessages.ADDED_PERIPHERAL, peripheral.getClass().getSimpleName(), peripheral.getId(), computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        List<Peripheral> peripherals = getComputer(computerId).getPeripherals();
        for (Peripheral currentPeripheral : peripherals) {
            if (currentPeripheral.getClass().getSimpleName().equals(peripheralType)) {
                peripherals.remove(currentPeripheral);
                return String.format(OutputMessages.REMOVED_PERIPHERAL, currentPeripheral.getClass().getSimpleName(), currentPeripheral.getId());
            }
        }
        throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_PERIPHERAL, peripheralType,
                getComputer(computerId).getClass().getSimpleName(), computerId));
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        Component component = createComponent(id, componentType, manufacturer, model, price, overallPerformance, generation);
        Computer computer = getComputer(computerId);

        putComponentToComputer(component, computer);
        return String.format(OutputMessages.ADDED_COMPONENT, component.getClass().getSimpleName(), component.getId(), computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        List<Component> components = getComputer(computerId).getComponents();
        for (Component currentComponent : components) {
            if (currentComponent.getClass().getSimpleName().equals(componentType)) {
                components.remove(currentComponent);
                return String.format(OutputMessages.REMOVED_COMPONENT, currentComponent.getClass().getSimpleName(), currentComponent.getId());
            }
        }
        throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_COMPONENT, componentType,
                getComputer(computerId).getClass().getSimpleName(), computerId));
    }

    @Override
    public String buyComputer(int id) {
        Computer computer = getComputer(id);
        if (computerList.contains(computer)) {
            computerList.remove(computer);
            return computer.toString();
        }
        throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
    }

    @Override
    public String BuyBestComputer(double budget) {
        double overallPerformance = 0.0;

        for (Computer computer : computerList) {
            if (computer.getOverallPerformance() > overallPerformance && computer.getPrice() <= budget){
                overallPerformance = computer.getOverallPerformance();
                computerList.remove(computer);
                return computer.toString();
            }
        }
        throw new IllegalArgumentException(String.format(ExceptionMessages.CAN_NOT_BUY_COMPUTER,budget));
    }


    @Override
    public String getComputerData(int id) {
        Computer computer = getComputer(id);
        if (computerList.contains(computer)) {
            return computer.toString();
        }
        throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
    }

    private Computer createComputer(String computerType, int id, String manufacturer, String model, double price) {
        Computer computer;
        if (computerType.equals("DesktopComputer")) {
            computer = new DesktopComputer(id, manufacturer, model, price);
        } else if (computerType.equals("Laptop")) {
            computer = new Laptop(id, manufacturer, model, price);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPUTER_TYPE);
        }
        return computer;
    }

    private Computer getComputer(int computerId) {
        for (Computer computer : computerList) {
            if (computer.getId() == computerId) {
                return computer;
            }
        }
        throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
    }

    private Component createComponent(int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        switch (componentType) {
            case "CentralProcessingUnit":
                return new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
            case "Motherboard":
                return new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
            case "PowerSupply":
                return new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
            case "RandomAccessMemory":
                return new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
            case "SolidStateDrive":
                return new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
            case "VideoCard":
                return new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
        }
    }

    private Peripheral createPeripheral(int id, String connectionType, String manufacturer, String model, double price, double overallPerformance) {
        switch (connectionType) {
            case "Headset":
                return new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
            case "Keyboard":
                return new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
            case "Monitor":
                return new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
            case "Mouse":
                return new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PERIPHERAL_TYPE);
        }
    }

    private void putComponentToComputer(Component component, Computer computer) {
        List<Component> components = computer.getComponents();

        for (Component currentComponent : components) {
            if (currentComponent.getId() == component.getId()) {
                throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPONENT_ID);
            }
        }
        computer.addComponent(component);
    }

    private void putPeripheralToComputer(Peripheral peripheral, Computer computer) {
        List<Peripheral> peripherals = computer.getPeripherals();

        for (Peripheral currentPeripheral : peripherals) {
            if (currentPeripheral.getId() == peripheral.getId()) {
                throw new IllegalArgumentException(ExceptionMessages.EXISTING_PERIPHERAL_ID);
            }
        }
        computer.addPeripheral(peripheral);
    }
}