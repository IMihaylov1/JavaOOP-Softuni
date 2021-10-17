package animals.factories.factoriesImplementation;

import animals.*;
import animals.factories.AnimalFactory;

public class AnimalFactoryImplementation implements AnimalFactory {
    public  Animal createAnimal(String type, String name, int age, String gender) {
        switch (type) {
            case "Cat":
                return new Cat(name, age, gender);
            case "Frog":
                return new Frog(name, age, gender);
            case "Kitten":
                return new Kitten(name, age);
            case "Tomcat":
                return new Tomcat(name, age);
            case "Dog":
                return new Dog(name, age, gender);
            default:
                throw new IllegalArgumentException("Invalid input!");
        }

    }
}
