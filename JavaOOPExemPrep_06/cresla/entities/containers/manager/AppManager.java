package cresla.entities.containers.manager;

import cresla.entities.containers.ModuleContainer;
import cresla.entities.containers.modules.CooldownSystem;
import cresla.entities.containers.modules.CryogenRod;
import cresla.entities.containers.modules.HeatProcessor;
import cresla.entities.containers.reactors.CryoReactor;
import cresla.entities.containers.reactors.HeatReactor;
import cresla.interfaces.*;
import cresla.interfaces.Module;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AppManager implements Manager {
    private Map<Integer, Reactor> reactors;
    private Map<Integer, Module> modules;
    private int id;
    private int energyModulesCounter;
    private int absorbingModulesCounter;
    private int cryoReactorCounter;
    private int heatReactorCounter;

    public AppManager() {
        this.reactors = new LinkedHashMap<>();
        this.modules = new LinkedHashMap<>();
        this. id = 1;
        this.energyModulesCounter = 0;
        this.absorbingModulesCounter = 0;
        this.cryoReactorCounter = 0;
        this.heatReactorCounter = 0;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        Container moduleContainer = new ModuleContainer(Integer.parseInt(arguments.get(3)));
        Reactor reactor = null;
        switch (arguments.get(1)){
            case "Cryo":
                reactor = new CryoReactor(moduleContainer, id, Integer.parseInt(arguments.get(2)));
                this.cryoReactorCounter++;
                break;
            case "Heat":
                reactor = new HeatReactor(moduleContainer, id, Integer.parseInt(arguments.get(2)));
                this.heatReactorCounter++;
                break;
        }
        this.reactors.put(id, reactor);
        return String.format("Created %s Reactor - %d", arguments.get(1), id++);
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        Module module = null;
        int reactorId = Integer.valueOf(arguments.get(1));

        switch (arguments.get(2)){
            case "CryogenRod":
                EnergyModule cryogenRod = new CryogenRod(id, Integer.parseInt(arguments.get(3)));
                module = cryogenRod;
                this.reactors.get(reactorId).addEnergyModule(cryogenRod);
                this.energyModulesCounter++;
                break;
            case "HeatProcessor":
                AbsorbingModule heatProcessor = new HeatProcessor(id, Integer.parseInt(arguments.get(3)));
                module = heatProcessor;
                this.reactors.get(reactorId).addAbsorbingModule(heatProcessor);
                this.absorbingModulesCounter++;
                break;
            case "CooldownSystem":
                AbsorbingModule coolingSystem = new CooldownSystem(id, Integer.parseInt(arguments.get(3)));
                module = coolingSystem;
                this.reactors.get(reactorId).addAbsorbingModule(coolingSystem);
                this.absorbingModulesCounter++;
                break;
        }
        this.modules.put(id, module);
        return String.format("Added %s - %d to Reactor - %d", arguments.get(2), id++, reactorId);
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int target = Integer.parseInt(arguments.get(1));
        if (this.reactors.containsKey(target)) {
            return this.reactors.get(target).toString();
        } else {
            return this.modules.get(target).toString();
        }
    }

    @Override
    public String exitCommand(List<String> arguments) {
        long totalEnergy = this.reactors.entrySet().stream()
                .mapToLong(r -> r.getValue().getTotalEnergyOutput()).sum();
        long totalHeat = this.reactors.entrySet().stream()
                .mapToLong(r -> r.getValue().getTotalHeatAbsorbing()).sum();

        return "Cryo Reactors: " + this.cryoReactorCounter + System.lineSeparator() +
                "Heat Reactors: " + this.heatReactorCounter + System.lineSeparator() +
                "Energy Modules: " + this.energyModulesCounter + System.lineSeparator() +
                "Absorbing Modules: " + this.absorbingModulesCounter + System.lineSeparator() +
                "Total Energy Output: " + totalEnergy + System.lineSeparator() +
                "Total Heat Absorbing: " + totalHeat;
    }
}