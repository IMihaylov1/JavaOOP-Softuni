package vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicles {
    public Car(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption,tankCapacity);
    }

    @Override
    void drive(double distance) {
        double fuelConsumption = super.getFuelConsumption() + 0.9;
        double  sum = distance * fuelConsumption;
        if (sum>super.getFuelQuantity()){
            System.out.println("Car needs refueling");
        }else {
            DecimalFormat decimalFormat = new DecimalFormat("###.##");
            double newFuel = super.getFuelQuantity() - sum;
            super.setFuelQuantity(newFuel);
            System.out.printf("Car travelled %s km%n",decimalFormat.format(distance));
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
