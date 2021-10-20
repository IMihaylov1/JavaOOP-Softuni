package easterRaces.repositories.interfaces;

import easterRaces.entities.racers.Race;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static easterRaces.common.ExceptionMessages.*;

public class RaceRepository<E> implements Repository<Race> {
    private Collection<Race> raceList;

    public RaceRepository() {
        raceList = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        for (Race race : raceList) {
            if (race.getName().equals(name)) {
                return race;
            }
        }
        throw new IllegalArgumentException(String.format(RACE_NOT_FOUND,name));
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(raceList);
    }

    @Override
    public void add(Race model) {
        if (isExistCar(model)) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, model.getName()));
        }
        raceList.add(model);
    }
    private boolean isExistCar(Race model) {
        for (Race race : raceList) {
            if (race.getName().equals(model.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Race model) {
        return raceList.removeIf(race -> race.getName().equals(model.getName()));
    }
}
