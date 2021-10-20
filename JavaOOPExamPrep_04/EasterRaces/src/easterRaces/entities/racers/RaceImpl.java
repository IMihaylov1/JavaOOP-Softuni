package easterRaces.entities.racers;

import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;

import static easterRaces.common.ExceptionMessages.*;


public class RaceImpl implements Race {
    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.drivers = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    public void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS, 1));
        }
        this.laps = laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return this.drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        //TODO Another Solution
//        if (driver == null) {
//            throw new IllegalArgumentException(DRIVER_INVALID);
//        } else if (driver.getCar() == null) {
//            throw new IllegalArgumentException(String.format(DRIVER_NOT_PARTICIPATE, driver.getName()));
//        }
//        boolean hasDriverInRace = this.getDrivers().stream()
//                .map(Driver::getName)
//                .anyMatch(targetName -> driver.getName().equals(targetName));
//        if (hasDriverInRace){
//            throw new IllegalArgumentException(String.format(DRIVER_ALREADY_ADDED
//                    , driver.getName(),this.getName() ));
//        }
//        this.drivers.add(driver);

            if (driver == null) {
                throw new IllegalArgumentException(DRIVER_INVALID);
            }
        if (driver.getCar() == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_PARTICIPATE, driver.getName()));
        }
        for (Driver driver1 : drivers) {
            if (driver1.getName().equals(driver.getName())) {
                throw new IllegalArgumentException(String.format(DRIVER_ALREADY_ADDED
                                             // ILI this.getClass.getSimpleName na mqstoto na tova
                        , driver.getName(),        this.getName()));

            }
        }
        this.drivers.add(driver);
    }
}
