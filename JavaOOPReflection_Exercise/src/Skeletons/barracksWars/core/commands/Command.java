package Skeletons.barracksWars.core.commands;

import Skeletons.barracksWars.interfaces.Executable;
import Skeletons.barracksWars.interfaces.Repository;
import Skeletons.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {

  private String[] data;
  private Repository repository;
  private UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected Repository getRepository() {
        return this.repository;
    }

    public String[] getData() {
        return this.data;
    }

    public UnitFactory getUnitFactory() {
        return this.unitFactory;
    }

}
