package Skeletons.barracksWars.core.commands;

import Skeletons.barracksWars.interfaces.Repository;
import Skeletons.barracksWars.interfaces.UnitFactory;

public class RetireCommand extends Command{
    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
         String output = "";

        try {
            this.getRepository().removeUnit(getData()[1]);

        } catch (Exception e) {
            output = e.getMessage();
        }
        return output;
    }
}
