package easterRaces.entities.drivers;

import easterRaces.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collection;

import static easterRaces.common.ExceptionMessages.CAR_INVALID;
import static easterRaces.common.ExceptionMessages.INVALID_NAME;

public class DriverImpl implements Driver {
    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;
    private Collection<Car> cars;

    public DriverImpl(String name) {
        setName(name);
        this.cars = new ArrayList<>();
        this.canParticipate = false;
    }

    private void setName(String name) {
        int needLenght = 5;
        if (name == null || name.length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, needLenght));
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Car getCar() {
        return cars.stream().min((f, c) -> Integer.compare(c.getHorsePower(), f.getHorsePower())).get();
    }

    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException(CAR_INVALID);
        }
        this.canParticipate = true;
        cars.add(car);
    }

    @Override
    public void winRace() {
        this.numberOfWins += 1;
    }

    @Override
    public boolean getCanParticipate() {
        return this.canParticipate;
    }
}