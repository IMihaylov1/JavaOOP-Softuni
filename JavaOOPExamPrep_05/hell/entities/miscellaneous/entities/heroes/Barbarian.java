package hell.entities.miscellaneous.entities.heroes;

public class Barbarian extends Heroes {
    private static final int STRENGTH_BARBARIAN = 90;
    private static final int AGILITY_BARBARIAN = 25;
    private static final int INTELLIGENCE_BARBARIAN = 10;
    private static final int HIT_POINTS_BARBARIAN = 350;
    private static final int DAMAGE_BARBARIAN = 150;


    public Barbarian(String name) {
        super(name, STRENGTH_BARBARIAN, AGILITY_BARBARIAN, INTELLIGENCE_BARBARIAN, HIT_POINTS_BARBARIAN,DAMAGE_BARBARIAN);
    }

}
