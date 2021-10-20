package hell.entities.miscellaneous.entities.items;

import hell.interfaces.Item;

public abstract class Items implements Item {
    private String name;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;
    private int hitPointsBonus;
    private int damageBonus;

    protected Items(String name, int strengthBonus, int agilityBonus,
                    int intelligenceBonus, int hitPointsBonus, int damageBonus) {
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.agilityBonus = agilityBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.hitPointsBonus = hitPointsBonus;
        this.damageBonus = damageBonus;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrengthBonus() {
        return this.strengthBonus;
    }

    @Override
    public int getAgilityBonus() {
        return this.agilityBonus;
    }

    @Override
    public int getIntelligenceBonus() {
        return this.intelligenceBonus;
    }

    @Override
    public int getHitPointsBonus() {
        return this.hitPointsBonus;
    }

    @Override
    public int getDamageBonus() {
        return this.damageBonus;
    }

    @Override
    public String toString() {
        String output = "###Item: " + this.getName() + System.lineSeparator() +
                "###+" + this.getStrengthBonus() + " Strength" + System.lineSeparator() +
                "###+" + this.getAgilityBonus() + " Agility" + System.lineSeparator() +
                "###+" + this.getIntelligenceBonus() + " Intelligence" + System.lineSeparator() +
                "###+" + this.getHitPointsBonus() + " HitPoints" + System.lineSeparator() +
                "###+" + this.getDamageBonus() + " Damage";

        return output.trim();
    }
}

