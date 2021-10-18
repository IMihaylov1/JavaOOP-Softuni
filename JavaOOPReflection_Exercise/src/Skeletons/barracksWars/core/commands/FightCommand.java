package Skeletons.barracksWars.core.commands;

import Skeletons.barracksWars.interfaces.Repository;
import Skeletons.barracksWars.interfaces.UnitFactory;

public class FightCommand  extends Command{
    public FightCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
       return "fight";
    }
}
