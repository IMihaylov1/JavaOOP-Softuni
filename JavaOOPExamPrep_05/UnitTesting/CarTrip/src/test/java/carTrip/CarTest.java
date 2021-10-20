package carTrip;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    @Test
    public void TestConstructor() {
        Car car = new Car("Reno", 10, 10, 10);
        String expected = "Reno";
        assertEquals(expected, car.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorExe() {
        Car car = new Car(null, -10, -10, -10);
    }

    @Test
    public void TestSetModelShouldWorkProperly() {
        Car car = new Car("Reno", 10, 10, 10);
        car.setModel("Volvo");
        assertEquals("Volvo", car.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSetModelShouldTrowExecWithNullModel() {
        Car car = new Car(null, 10, 10, 10);

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSetModelShouldTrowExecWithEmptyModel() {
        Car car = new Car("", 10, 10, 10);

    }

    @Test
    public void TestGetTankCapacity() {
        Car car = new Car("Reno", 10, 10, 10);
        double expected = car.getTankCapacity();
        assertEquals(expected, car.getTankCapacity(), 0);
    }

    @Test
    public void TestSetTankCapacity() {
        Car car = new Car("Reno", 10, 10, 10);
        car.setTankCapacity(100);
        assertEquals(100, car.getTankCapacity(), 0);
    }

    @Test
    public void TestGetFuelAmount() {
        Car car = new Car("Reno", 10, 10, 10);
        double expected = car.getFuelAmount();
        assertEquals(expected, car.getFuelAmount(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSetFuelAmountShouldTrowExcWithFuelAmountBiggerThenTankCapacity() {
        Car car = new Car("Reno", 10, 10, 10);
        double fuelAmount = 20;
        car.setFuelAmount(fuelAmount);
    }

    @Test
    public void TestSetFuelAmount() {
        Car car = new Car("Reno", 100, 10, 10);
        car.setFuelAmount(5);
    }

    @Test
    public void TestSetFuelShouldWork() {
        Car car = new Car("Reno", 10, 10, 10);
        double fuelAmount = 1;
        car.setFuelAmount(fuelAmount);
        double expected = 1;
        assertEquals(expected, car.getFuelAmount(), 0);
    }

    @Test
    public void TestCarGetFuelConsumptionPerKmShouldWorkProperly() {
        Car car = new Car("Reno", 10, 10, 10);
        double expected = car.getFuelConsumptionPerKm();
        assertEquals(expected, car.getFuelConsumptionPerKm(), 0);
    }

    @Test
    public void TestSetFuelConsumptionPerKm() {
        Car car = new Car("Reno", 10, 10, 10);
        car.setFuelConsumptionPerKm(2);
        double fuelConsumptionPerKm = car.getFuelConsumptionPerKm();
        assertEquals(fuelConsumptionPerKm, car.getFuelConsumptionPerKm(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSetFuelConsumptionPerKmShouldTrowExcWithParamNegative() {
        Car car = new Car("Reno", 10, 10, 10);
        car.setFuelConsumptionPerKm(-2);

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSetFuelConsumptionPerKmShouldTrowExcWithZero() {
        Car car = new Car("Reno", 10, 10, 10);
        car.setFuelConsumptionPerKm(0);

    }

    @Test
    public void TestDriveShouldWorkProperly() {
        Car car = new Car("Reno", 20, 20, 10);
        car.drive(1);
        car.setFuelAmount(car.getFuelAmount() - 1 * car.getFuelConsumptionPerKm());

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestDriveShouldTrowExc() {
        Car car = new Car("Reno", 10, 20, 10);
        car.drive(10);
    }

    @Test
    public void TestRefuel() {
        Car car = new Car("Reno", 100, 20, 10);
        car.refuel(20);
        car.setFuelAmount(20 + car.getFuelAmount());
        assertEquals(car.getFuelAmount(), car.getFuelAmount(), 0);
    }

    @Test(expected = IllegalStateException.class)
    public void TestRefuelShouldTrowExc() {
        Car car = new Car("Reno", 20, 20, 10);
        car.refuel(20);

    }
}