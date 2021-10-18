package vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicles {
    public Truck(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption,tankCapacity);
    }

    @Override
    void drive(double distance) {
        double fuelConsumption = super.getFuelConsumption() + 1.6;
        double sum = distance * fuelConsumption;
        if (sum > super.getFuelQuantity()) {
            System.out.println("Truck needs refueling");
        } else {
            DecimalFormat decimalFormat = new DecimalFormat("###.##");
            double newFuel = super.getFuelQuantity() - sum;
            super.setFuelQuantity(newFuel);
            System.out.printf("Truck travelled %s km%n", decimalFormat.format(distance));
        }
    }

    @Override
    void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
        }else {
            double littersToPut = super.getFuelQuantity() + liters * 0.95;
            if(super.getTankCapacity()<littersToPut){
                System.out.println("Cannot fit fuel in tank");
            }else {
                super.setFuelQuantity(littersToPut);
            }
        }

    }
}
