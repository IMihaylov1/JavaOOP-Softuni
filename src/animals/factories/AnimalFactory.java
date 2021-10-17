package animals.factories;

import animals.Animal;

public interface AnimalFactory {
    Animal createAnimal(String type, String name, int age, String gender);
}
