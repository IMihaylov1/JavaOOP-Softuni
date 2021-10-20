package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_REPOSITORY;


public class GunRepository implements Repository<Gun> {
    private List<Gun> guns;

    public GunRepository() {
        this.guns = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return this.guns;
    }

    @Override
    public void add(Gun model) {
        if (model == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
       this.guns.add(model);
    }

    @Override
    public boolean remove(Gun model) {
        return this.guns.remove(model);

    }

    @Override
    public Gun findByName(String name) {
        for (Gun gun : guns) {
                if(gun.getName().equals(name)){
                    return gun;
                }
        }
        return null;
    }
}
