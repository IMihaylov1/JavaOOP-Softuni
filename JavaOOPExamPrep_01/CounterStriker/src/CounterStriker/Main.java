package CounterStriker;

import CounterStriker.core.EngineImpl;
import CounterStriker.core.Engine;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();


    }
}
