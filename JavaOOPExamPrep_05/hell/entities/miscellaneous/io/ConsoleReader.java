package hell.entities.miscellaneous.io;

import hell.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleReader implements InputReader {
    private BufferedReader reader;


    @Override
    public String readLine() throws IOException {
        return this.reader.readLine();
    }
}
