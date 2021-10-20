package easterRaces.repositories.interfaces;

import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static easterRaces.common.ExceptionMessages.DRIVER_NOT_FOUND;

public class DriverRepository<E> implements Repository<Driver> {
    private Collection<Driver> drivers;

    public DriverRepository() {
        drivers = new ArrayList<>();
    }

    @Override
    public Driver getByName(String name) {
        for (Driver driver : drivers) {
            if (driver.getName().equals(name)) {
                return driver;
            }
        }
        throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND,name));
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(drivers);
    }

    @Override
    public void add(Driver model) {

        drivers.add(model);

    }

    @Override
    public boolean remove(Driver model) {
        return drivers.removeIf(driver -> driver.getName().equals(model.getName()));
    }
}