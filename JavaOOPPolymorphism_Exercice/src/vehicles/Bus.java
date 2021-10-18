package vehicles;

import java.text.DecimalFormat;

public class Bus extends Vehicles{
    private boolean isEmpty;
    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.isEmpty = false;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    void drive(double distance) {
        if(isEmpty){
            double fuelConsumption = super.getFuelConsumption() + 1.4;
            double  sum = distance * fuelConsumption;
            if (sum>super.getFuelQuantity()){
                System.out.println("Bus needs refueling");
            }else {
                DecimalFormat decimalFormat = new DecimalFormat("###.##");
                double newFuel = super.getFuelQuantity() - sum;
                super.setFuelQuantity(newFuel);
                System.out.printf("Bus travelled %s km%n",decimalFormat.format(distance));
            }
        }else {
            double fuelConsumption = super.getFuelConsumption();
            double sum = distance * fuelConsumption;
            if (sum > super.getFuelQuantity()) {
                System.out.println("Bus needs refueling");
            } else {
                DecimalFormat decimalFormat = new DecimalFormat("###.##");
                double newFuel = super.getFuelQuantity() - sum;
                super.setFuelQuantity(newFuel);
                System.out.printf("Bus travelled %s km%n", decimalFormat.format(distance));
            }
        }
    }

    @Override
    void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
        }else {
            double addedFuel = super.getFuelQuantity() + liters;
            if(super.getTankCapacity()<addedFuel){
                System.out.println("Cannot fit fuel in tank");
            }else {
                super.setFuelQuantity(addedFuel);
            }
        }
    }
}
