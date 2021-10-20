package robotService.models.procedures.interfaces;

import robotService.models.robots.interfaces.Robot;

import java.util.ArrayList;
import java.util.Collection;

import static robotService.common.ExceptionMessages.INSUFFICIENT_PROCEDURE_TIME;

public abstract class BaseProcedure implements Procedure {
    private Collection<Robot> robots;

    protected BaseProcedure() {
        this.robots = new ArrayList<>();
    }

    @Override
    public String history() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
       sb .append(System.lineSeparator());
        for (Robot robot : robots) {
            sb.append(robot.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }


    @Override
    public void doService(Robot robot, int procedureTime) {
        if (robot.getProcedureTime() < procedureTime) {
            throw new IllegalArgumentException(INSUFFICIENT_PROCEDURE_TIME);
        }
        int newProcedureTime = robot.getProcedureTime() - procedureTime;
        robot.setProcedureTime(newProcedureTime);
        this.robots.add(robot);
    }
}
