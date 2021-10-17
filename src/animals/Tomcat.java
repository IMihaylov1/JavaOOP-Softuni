package animals;

public class Tomcat  extends  Cat{

    public Tomcat(String name, int age) {
        super(name, age, Constants.MALE_GENDER);
    }

    @Override
    public String produceSound(){
        return Constants.TOMCAT_SOUND;
    }
}
