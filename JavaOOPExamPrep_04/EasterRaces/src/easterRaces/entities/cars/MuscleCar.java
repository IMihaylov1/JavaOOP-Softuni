package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class MuscleCar extends BaseCar {
    private static final double CUBIC_CENTIMETERS = 5000;
    private static final int LOW_HORSE_POWER = 400;
    private static final int HIGH_HORSE_POWER = 600;

    public MuscleCar(String model, int horsePower) {
        super(model, setHorsePower(horsePower), CUBIC_CENTIMETERS);
    }



    private static int setHorsePower(int horsePower) {
        if (horsePower < LOW_HORSE_POWER || horsePower > HIGH_HORSE_POWER) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
        return horsePower;
    }
}
