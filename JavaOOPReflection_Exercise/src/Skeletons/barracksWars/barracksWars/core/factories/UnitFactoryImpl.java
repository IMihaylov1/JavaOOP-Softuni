package Skeletons.barracksWars.barracksWars.core.factories;


import Skeletons.barracksWars.interfaces.Unit;
import Skeletons.barracksWars.interfaces.UnitFactory;
import Skeletons.barracksWars.models.units.AbstractUnit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "Skeletons.barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        try {
            Class<?> unit = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<?> declaredConstructor = unit.getDeclaredConstructor();
            Object object = declaredConstructor.newInstance();

            if(object instanceof AbstractUnit){
                return (Unit) object;
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Provided type invalid!");
    }
}
