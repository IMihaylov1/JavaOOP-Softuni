package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static easterRaces.common.ExceptionMessages.CAR_EXISTS;
import static easterRaces.common.ExceptionMessages.CAR_NOT_FOUND;

public class CarRepository<E> implements Repository<Car> {
    private Collection<Car> cars;

    public CarRepository() {
        this.cars = new ArrayList<>();
    }

    @Override
    public Car getByName(String name) {
        for (Car car : cars) {
            if (car.getModel().equals(name)) {
                return car;
            }
        }
        throw new IllegalArgumentException(String.format(CAR_NOT_FOUND,name));
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(cars);
    }

    @Override
    public void add(Car model) {
        if (isExistCar(model)) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model.getModel()));
        }
        cars.add(model);
    }

    private boolean isExistCar(Car model) {
        for (Car car : cars) {
            if (car.getModel().equals(model.getModel())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Car model) {
        return cars.removeIf(car -> car.getModel().equals(model.getModel()));
    }
}
