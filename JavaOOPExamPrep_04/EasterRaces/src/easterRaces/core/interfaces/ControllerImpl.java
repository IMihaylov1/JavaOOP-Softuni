package easterRaces.core.interfaces;

import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static easterRaces.common.ExceptionMessages.*;
import static easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Driver> riderRepository;
    private Repository<Car> motorcycleRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> riderRepository, Repository<Car> motorcycleRepository, Repository<Race> raceRepository) {
        this.riderRepository = riderRepository;
        this.motorcycleRepository = motorcycleRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        riderRepository.add(new DriverImpl(driver));
        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car;
        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new SportsCar(model, horsePower);
                break;
            default:
                throw new IllegalArgumentException("");
        }
        motorcycleRepository.add(car);
        return String.format(CAR_CREATED, car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = riderRepository.getByName(driverName);
        Car car = motorcycleRepository.getByName(carModel);
        driver.addCar(car);
        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = raceRepository.getByName(raceName);
        Driver driver = riderRepository.getByName(driverName);
        race.addDriver(driver);
        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);
        if (race.getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }
        StringBuilder print = new StringBuilder();
        List<Driver> position = race.getDrivers().stream()
                .sorted((d1, d2) -> Double.compare(d2.getCar().calculateRacePoints(race.getLaps()), d1.getCar().calculateRacePoints(race.getLaps())))
                .collect(Collectors.toList());
        print.append(String.format(DRIVER_FIRST_POSITION, position.get(0).getName(), raceName)).append(System.lineSeparator());
        print.append(String.format(DRIVER_SECOND_POSITION, position.get(1).getName(), raceName)).append(System.lineSeparator());
        print.append(String.format(DRIVER_THIRD_POSITION, position.get(2).getName(), raceName)).append(System.lineSeparator());

        raceRepository.remove(race);
        return print.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        raceRepository.add(new RaceImpl(name, laps));
        return String.format(RACE_CREATED, name);
    }
}