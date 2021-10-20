package hell;


import hell.interfaces.Manager;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Manager manager = new ManagerImpl();
        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Quit")) {
            String[] tokens = commandLine.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Hero":
                    System.out.println(manager.addHero(Arrays.asList(tokens)));
                    break;
                case "Item":
                    System.out.println(manager.addItem(Arrays.asList(tokens)));
                    break;
                case "Recipe":
                    System.out.println(manager.addRecipe(Arrays.asList(tokens)));
                    break;
                case "Inspect":
                    System.out.println(manager.inspect(Arrays.asList(tokens)));
                    break;
                default:
                    break;
            }

            commandLine = scanner.nextLine();
        }

        System.out.println(manager.quit());
    }
}