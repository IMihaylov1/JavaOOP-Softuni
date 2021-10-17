package person;

public class Rebel implements Buyer,Person{
    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGroup() {
        return this.group;
    }

    private void setFood(int food) {
        this.food = food;
    }

    @Override
    public void buyFood() {
        this.setFood(this.getFood()+5);
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
