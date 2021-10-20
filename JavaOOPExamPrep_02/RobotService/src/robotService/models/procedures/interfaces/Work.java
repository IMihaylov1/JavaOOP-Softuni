package robotService.models.procedures.interfaces;

import robotService.models.robots.interfaces.Robot;

public class Work extends BaseProcedure {


    @Override
    public void doService(Robot robot, int procedureTime) {
        super.doService(robot, procedureTime);

        int newHappiness = robot.getHappiness() + 12;
        int newEnergy = robot.getEnergy() - 6;

        robot.setHappiness(newHappiness);
        robot.setEnergy(newEnergy);

    }
}
