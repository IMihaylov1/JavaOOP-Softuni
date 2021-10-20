package hell.entities.miscellaneous.entities.heroes;


public class Wizard extends Heroes {
    private static final int STRENGTH_WIZARD = 25;
    private static final int AGILITY_WIZARD = 25;
    private static final int INTELLIGENCE_WIZARD = 100;
    private static final int HIT_POINTS_WIZARD = 100;
    private static final int DAMAGE_WIZARD = 250;


    public Wizard(String name) {
        super(name, STRENGTH_WIZARD, AGILITY_WIZARD, INTELLIGENCE_WIZARD, HIT_POINTS_WIZARD,DAMAGE_WIZARD);
    }

}
