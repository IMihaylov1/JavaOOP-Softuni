package hell.entities.miscellaneous.entities.heroes;

import hell.entities.miscellaneous.miscellaneous.HeroInventory;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;


public abstract class Heroes implements Hero {
    private String name;
    private long strength;
    private long agility;
    private long intelligence;
    private long hitPoints;
    private long damage;
    private Inventory inventory;

    protected Heroes(String name, int strength, int agility, int intelligence, int hitPoints, int damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = new HeroInventory();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }


    @Override
    public long getIntelligence() {
        return this.intelligence+ this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints+this.inventory.getTotalHitPointsBonus();
    }


    @Override
    public long getDamage() {
        return this.damage+this.inventory.getTotalDamageBonus();
    }


    @Override
    public Collection<Item> getItems() {
        try {
            Field field = this.inventory.getClass().getDeclaredField("commonItems");
            field.setAccessible(true);
            return ((Map<String, Item>) field.get(this.inventory)).values();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Hero: ").append(this.getName()).append(", Class: ").append(this.getClass().getSimpleName()).append(System.lineSeparator());
        output.append("HitPoints: ").append(this.getHitPoints()).append(", Damage: ").append(this.getDamage()).append(System.lineSeparator());
        output.append("Strength: ").append(this.getStrength()).append(System.lineSeparator());
        output.append("Agility: ").append(this.getAgility()).append(System.lineSeparator());
        output.append("Intelligence: ").append(this.getIntelligence()).append(System.lineSeparator());

        if (this.getItems().isEmpty()) {
            output.append("Items: None");
        } else {
            output.append("Items:").append(System.lineSeparator());
            for (Item item : this.getItems()) {
                output.append(item.toString());
            }
        }

        return output.toString().trim();
    }
}