package Skeletons.barracksWars;

import Skeletons.barracksWars.barracksWars.core.Engine;
import Skeletons.barracksWars.barracksWars.core.factories.UnitFactoryImpl;
import Skeletons.barracksWars.data.UnitRepository;
import Skeletons.barracksWars.interfaces.Repository;
import Skeletons.barracksWars.interfaces.UnitFactory;

public class Main {
    public static void main(String[] args) {

        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();

    }
}
