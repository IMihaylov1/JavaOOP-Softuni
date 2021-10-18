package Skeletons.barracksWars.core.commands;

import Skeletons.barracksWars.interfaces.Repository;
import Skeletons.barracksWars.interfaces.UnitFactory;

public class ReportCommand extends Command {
    public ReportCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return
                this.getRepository().getStatistics();
    }
}
