package cresla.entities.containers.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;

import java.lang.reflect.Field;
import java.util.LinkedList;

public abstract class BaseReactor implements Reactor {

    private int id;
    private Container moduleContainer;

    protected BaseReactor(Container moduleContainer, int id) {
        this.id = id;
        this.moduleContainer = moduleContainer;
    }

    @Override
    public int getId() {
        return this.id;
    }

    Container getModuleContainer(){
        return this.moduleContainer;
    }

    @Override
    public abstract long getTotalEnergyOutput();

    @Override
    public abstract long getTotalHeatAbsorbing();

    @Override
    @SuppressWarnings("unchecked")
    public int getModuleCount() {
        Class moduleContainerClass = ModuleContainer.class;
        Field field = moduleContainerClass.getDeclaredFields()[1];
        field.setAccessible(true);

        try {
            return ((LinkedList<Module>)field.get(this.moduleContainer)).size();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.moduleContainer.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.moduleContainer.addAbsorbingModule(absorbingModule);
    }
}
