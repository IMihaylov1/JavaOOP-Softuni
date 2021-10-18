package wildFarm;

import java.text.DecimalFormat;

public class Cat  extends Feline {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion,String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    void eat(Food food) {
        Integer quantity = food.getQuantity()+this.getFoodEaten();
        this.setFoodEaten(quantity);
    }
    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getAnimalName(),super.getAnimalType()
                ,this.getBreed(),decimalFormat.format(super.getAnimalWeight())
                ,super.getLivingRegion(),super.getFoodEaten());
    }
}
