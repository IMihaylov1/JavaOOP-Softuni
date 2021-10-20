package hell.entities.miscellaneous.entities.heroes;

public class Assassin extends Heroes {
    private static final int STRENGTH_ASSASSIN = 25;
    private static final int AGILITY_ASSASSIN = 100;
    private static final int INTELLIGENCE_ASSASSIN = 15;
    private static final int HIT_POINTS_ASSASSIN = 150;
    private static final int DAMAGE_ASSASSIN = 300;

    public Assassin(String name) {
        super(name, STRENGTH_ASSASSIN, AGILITY_ASSASSIN, INTELLIGENCE_ASSASSIN,HIT_POINTS_ASSASSIN, DAMAGE_ASSASSIN);
    }
}
