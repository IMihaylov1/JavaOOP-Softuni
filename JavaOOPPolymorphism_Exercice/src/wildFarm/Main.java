package wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();


        while (!command.equals("End")) {
            String[] animalInfo = command.split("\\s+");
            String[] foodInfo = scanner.nextLine().split("\\s+");
            Food food;
            food = getFood(foodInfo);

            feedingTheAnimal(animals, animalInfo, food);
            command = scanner.nextLine();
        }
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }



    public static void feedingTheAnimal(List<Animal> animals, String[] animalInfo, Food food) {
        switch (animalInfo[0]) {
            case "Mouse":
                Mouse mouse = new Mouse(animalInfo[0], animalInfo[1],
                        Double.parseDouble(animalInfo[2]), animalInfo[3]);
                mouse.makeSound();
                mouse.eat(food);
                animals.add(mouse);
                break;
            case "Cat":
                Cat cat = new Cat(animalInfo[0], animalInfo[1],
                        Double.parseDouble(animalInfo[2]), animalInfo[3], animalInfo[4]);
                cat.makeSound();
                cat.eat(food);
                animals.add(cat);
                break;
            case "Tiger":
                Tiger tiger = new Tiger(animalInfo[0], animalInfo[1],
                        Double.parseDouble(animalInfo[2]), animalInfo[3]);
                tiger.makeSound();
                tiger.eat(food);
                animals.add(tiger);
                break;
            case "Zebra":
                Zebra zebra = new Zebra(animalInfo[0], animalInfo[1],
                        Double.parseDouble(animalInfo[2]), animalInfo[3]);
                zebra.makeSound();
                zebra.eat(food);
                animals.add(zebra);
                break;
            case "Felime":
                Feline felime = new Feline(animalInfo[0], animalInfo[1],
                        Double.parseDouble(animalInfo[2]), animalInfo[3]);
                felime.eat(food);
                animals.add(felime);
                break;
        }
    }


    public static Food getFood(String[] foodInfo) {
        Food food;
        if (foodInfo[0].equals("Vegetable")) {
            food = new Vegetable(Integer.parseInt(foodInfo[1]));
        } else {
            food = new Meat(Integer.parseInt(foodInfo[1]));
        }
        return food;
    }
}
