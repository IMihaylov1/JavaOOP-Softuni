package vehicles;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String[] carInfo = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2])
                , Double.parseDouble(carInfo[3]));

        String[] truckInfo = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2])
                , Double.parseDouble(truckInfo[3]));

        String[] busInfo = scanner.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2])
                , Double.parseDouble(busInfo[3]));

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            driveAndRefuel(car, truck, bus, tokens);
        }
        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f", bus.getFuelQuantity());
    }

    public static void driveAndRefuel(Car car, Truck truck, Bus bus, String[] tokens) {
        switch (tokens[0]) {
            case "Drive":
                if (tokens[1].equals("Car")) {
                    car.drive(Double.parseDouble(tokens[2]));
                } else if (tokens[1].equals("Truck")) {
                    truck.drive(Double.parseDouble(tokens[2]));
                } else {
                    bus.setEmpty(true);
                    bus.drive(Double.parseDouble(tokens[2]));
                }
                break;
            case "Refuel":
                if (tokens[1].equals("Car")) {
                    car.refuel(Double.parseDouble(tokens[2]));
                } else if(tokens[1].equals("Truck")) {
                    truck.refuel(Double.parseDouble(tokens[2]));
                }else {

                    bus.refuel(Double.parseDouble(tokens[2]));
                }
                break;
            case "DriveEmpty":
                bus.setEmpty(false);
                bus.drive(Double.parseDouble(tokens[2]));

                break;
        }
    }
}
