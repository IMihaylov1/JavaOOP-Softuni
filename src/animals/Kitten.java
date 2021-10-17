package animals;

public class Kitten extends Cat {


    public Kitten(String name, int age) {
        super(name, age, Constants.FEMALE_GENDER);
    }
    @Override
    public String produceSound(){
    return Constants.KITTEN_SOUND;
    }
}
