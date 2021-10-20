package garage;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;


public class GarageTests {

    private static Garage garage;
    private static final Car[] DEFAULT_CARS = {new Car("Mercedes", 320, 200000)
            , new Car("BMW", 300, 150000), new Car("Opel", 190, 15000)};

    @Before
    public void setUp() {
        garage = new Garage();
    }

    @Test
    public void Test_getCarsIfNotEmpty() {
        garage.addCar(new Car("Mercedes", 320, 200000));
        Assert.assertFalse(garage.getCars().isEmpty());

    }

    @Test
    public void Test_getCarsIfEmpty() {
        Assert.assertTrue(garage.getCars().isEmpty());
    }

    @Test
    public void Test_constructor() {
        Garage gar = new Garage();
        Assert.assertEquals(0, gar.getCount());
        Assert.assertTrue(gar.getCars().isEmpty());
        Assert.assertNull(gar.getTheMostExpensiveCar());
        Assert.assertTrue(gar.findAllCarsWithMaxSpeedAbove(100).isEmpty());
        Assert.assertTrue(gar.findAllCarsByBrand("Test").isEmpty());
    }

    @Test
    public void TEST_findAllCarsWithMaxSpeedAboveIfExist() {
        for (Car car : DEFAULT_CARS) {
            garage.addCar(car);
        }
        int checkSpeed = 200;

        List<Car> cars = garage.getCars().stream().filter(c -> c.getMaxSpeed() > checkSpeed).collect(Collectors.toList());
        for (Car car : cars) {
            boolean chek = checkSpeed < car.getMaxSpeed();
            Assert.assertTrue(chek);
        }
    }

    @Test
    public void TEST_findAllCarsWithMaxSpeedAboveEmpty() {
        int checkSpeed = 200;
        List<Car> cars = garage.getCars().stream().filter(c -> c.getMaxSpeed() > checkSpeed).collect(Collectors.toList());
        Assert.assertTrue(cars.isEmpty());
    }

    @Test
    public void TEST_getCount() {
        for (Car car : DEFAULT_CARS) {
            garage.addCar(car);
        }
        int size = DEFAULT_CARS.length;
        Assert.assertEquals("Count of elements is incorrect", size, garage.getCount());
    }

    @Test
    public void TEST_getCountEmptyCollection() {
        Assert.assertEquals("Count of elements is incorrect", 0, garage.getCount());
    }

    @Test
    public void Test_addValidCar() {
        Car temp = new Car("Golf", 180, 12000);
        garage.addCar(temp);
        //  Assert.assertEquals(temp, garage.getCars().get(0));
        Assert.assertEquals(1, garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_addNotValidCarThrowException() throws IllegalArgumentException {
        garage.addCar(null);
    }

    @Test
    public void TESt_getTheMostExpensiveCarReturnValidCar() {
        double temp = DEFAULT_CARS[0].getPrice();
        for (Car car : DEFAULT_CARS) {
            garage.addCar(car);
        }
        Car get = garage.getTheMostExpensiveCar();
        Assert.assertEquals(temp, get.getPrice(), 0.0);

    }

    @Test()
    public void TESt_getTheMostExpensiveCarEmptyGarage() {
        Car get = garage.getTheMostExpensiveCar();
        Assert.assertNull(get);
    }

    @Test
    public void Test_findAllCarsByBrandIfHave() {
        String brand = "Mercedes";
        for (Car car : DEFAULT_CARS) {
            garage.addCar(car);
        }
        garage.addCar(new Car(brand, 260, 150000));
        List<Car> temp = garage.findAllCarsByBrand(brand);
        Assert.assertEquals(2, temp.size());
//        for (Car car : temp) {
//            Assert.assertEquals(brand, car.getBrand());
//        }
    }

    @Test
    public void Test_findAllCarsByBrandIfMissed() {
        String brand = "Mercedes";
        List<Car> temp = garage.findAllCarsByBrand(brand);
        Assert.assertTrue(garage.getCars().isEmpty());
    }
}