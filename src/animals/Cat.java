package animals;

public class Cat extends Animal{

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound(){
      return Constants.CAT_SOUND;
    }
}
