package wildFarm;

public abstract class  Animal {
    private String animalName;
    private  String animalType;
    private  Double animalWeight;
    private  Integer foodEaten;

    protected Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    protected String getAnimalName() {
        return this.animalName;
    }

    protected void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    protected String getAnimalType() {
        return this.animalType;
    }

    protected void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    protected Double getAnimalWeight() {
        return this.animalWeight;
    }

    protected void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }

    protected Integer getFoodEaten() {
        return this.foodEaten;
    }

    protected void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    abstract void makeSound();
    abstract void eat(Food food);


}

