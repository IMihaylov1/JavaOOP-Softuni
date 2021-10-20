package cresla.entities.containers.io;

import cresla.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {


    @Override
    public void write(String output) {
        System.out.print(output);
    }

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }
}
