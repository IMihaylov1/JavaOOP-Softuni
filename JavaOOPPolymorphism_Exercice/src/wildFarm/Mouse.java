package wildFarm;

import java.text.DecimalFormat;

public class Mouse extends Mammal {
    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")){
            Integer quantity = food.getQuantity()+this.getFoodEaten();
            this.setFoodEaten(quantity);
        }else {
            System.out.println("Mice are not eating that type of food!");
        }
    }
    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        return String.format("%s[%s, %s, %s, %d]",super.getAnimalName(),super.getAnimalType(),decimalFormat.format(super.getAnimalWeight())
                ,super.getLivingRegion(),super.getFoodEaten());
    }
}
