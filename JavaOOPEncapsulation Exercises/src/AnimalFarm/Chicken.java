package AnimalFarm;

public class Chicken {

    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public Chicken(String name) {
        this.setName(name);
        this.setAge(1);
    }

    public void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public void setName(String name) {
        if (name.length() < 1 || name.trim().isEmpty() || name.equals(" ")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public double productPerDay() {
        if(this.age<6){
            return 2;
        }else if(this.age<12){
            return 1;
        }else {
            return 0.75;
        }
    }

    private double calculateProductPerDay() {
        double eggsPerDay = 0;
        if (this.age <= 5) {
            eggsPerDay = 2;
        } else if (this.age <= 11) {
            eggsPerDay = 1;
        } else if (this.age <= 15) {
            eggsPerDay = 0.75;
        }
        return eggsPerDay;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", this.name, this.age, calculateProductPerDay());
    }
}