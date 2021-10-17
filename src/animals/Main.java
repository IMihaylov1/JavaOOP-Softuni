package animals;

import animals.factories.AnimalFactory;
import animals.factories.factoriesImplementation.AnimalFactoryImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AnimalFactory animalFactory = new AnimalFactoryImplementation();

        String type = scanner.nextLine();
        List<Animal> animalList = new ArrayList<>();

        while (!type.equals("Beast!")) {

            String[] param = scanner.nextLine().split("\\s+");
            String name = param[0];
            int age = Integer.parseInt(param[1]);
            String gender = param[2];
            try {
                Animal animal = animalFactory.createAnimal(type,name,age,gender);
                animalList.add(animal);

            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }


            type = scanner.nextLine();
        }
        for (Animal animal : animalList) {
            System.out.println(animal);
        }


    }
}
