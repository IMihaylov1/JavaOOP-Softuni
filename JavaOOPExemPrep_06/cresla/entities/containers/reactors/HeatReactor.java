package cresla.entities.containers.reactors;

import cresla.interfaces.Container;

public class HeatReactor extends BaseReactor {
    private int heatReductionIndex;

    public HeatReactor(Container moduleContainer, int id, int heatReductionIndex) {
        super(moduleContainer, id);
        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long result = super.getModuleContainer().getTotalEnergyOutput();
        if (result > this.getTotalHeatAbsorbing()) {
            result = 0;
        }
        return result;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getModuleContainer().getTotalHeatAbsorbing() + this.heatReductionIndex;
    }

    @Override
    public String toString() {
        return "HeatReactor - " + super.getId() + System.lineSeparator() +
                "Energy Output: " + this.getTotalEnergyOutput() + System.lineSeparator() +
                "Heat Absorbing: " + this.getTotalHeatAbsorbing() + System.lineSeparator() +
                "Modules: " + super.getModuleCount();
    }
}

