package cresla;

import cresla.entities.containers.io.ConsoleReader;
import cresla.entities.containers.io.ConsoleWriter;
import cresla.entities.containers.manager.AppManager;
import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Manager manager = new AppManager();
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();

        whileLoop:
        while (true) {
            List<String> input = Arrays.asList(reader.readLine().split(("\\s+")));
            switch (input.get(0)) {
                case "Reactor":
                    writer.writeLine(manager.reactorCommand(input));
                    break;
                case "Module":
                    writer.writeLine(manager.moduleCommand(input));
                    break;
                case "Report":
                    writer.writeLine(manager.reportCommand(input));
                    break;
                case "Exit":
                    writer.writeLine(manager.exitCommand(input));
                    break whileLoop;
            }
        }
    }
}