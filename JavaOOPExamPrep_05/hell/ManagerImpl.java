package hell;

import hell.entities.miscellaneous.entities.heroes.Assassin;
import hell.entities.miscellaneous.entities.heroes.Barbarian;
import hell.entities.miscellaneous.entities.heroes.Wizard;
import hell.entities.miscellaneous.entities.items.CommonItem;
import hell.entities.miscellaneous.entities.items.RecipeItem;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Manager;
import hell.interfaces.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ManagerImpl implements Manager {

    private Map<String, Hero> heroes;

    public ManagerImpl() {
        this.heroes = new HashMap<>();
    }

    @Override
    public String addHero(List<String> arguments) {

        String name = arguments.get(1);
        String type = arguments.get(2);

        Hero hero = null;
        switch (type) {
            case "Barbarian":
                hero = new Barbarian(name);
                break;
            case "Assassin":
                hero = new Assassin(name);
                break;
            case "Wizard":
                hero = new Wizard(name);
                break;
            default:
                break;
        }

        this.heroes.put(name, hero);
        return "Created " + type + " - " + name;
    }

    @Override
    public String addItem(List<String> arguments) {
        String itemName = arguments.get(1);
        String heroName = arguments.get(2);
        int strengthBonus = Integer.parseInt(arguments.get(3));
        int agilityBonus = Integer.parseInt(arguments.get(4));
        int intelligenceBonus = Integer.parseInt(arguments.get(5));
        int hitPointsBonus = Integer.parseInt(arguments.get(6));
        int damageBonus = Integer.parseInt(arguments.get(7));

        Item item = new CommonItem(itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.heroes.get(heroName).addItem(item);
        return "Added item - " + itemName + " to Hero - " + heroName;
    }

    @Override
    public String addRecipe(List<String> arguments) {
        String itemName = arguments.get(1);
        String heroName = arguments.get(2);
        int strengthBonus = Integer.parseInt(arguments.get(3));
        int agilityBonus = Integer.parseInt(arguments.get(4));
        int intelligenceBonus = Integer.parseInt(arguments.get(5));
        int hitPointsBonus = Integer.parseInt(arguments.get(6));
        int damageBonus = Integer.parseInt(arguments.get(7));

        List<String> requiredItems = arguments.stream().skip(8).collect(Collectors.toList());

        Recipe recipe = new RecipeItem(itemName, strengthBonus, agilityBonus, intelligenceBonus
                , hitPointsBonus, damageBonus, requiredItems);
        this.heroes.get(heroName).addRecipe(recipe);
        return "Added recipe - " + itemName + " to Hero - " + heroName;
    }

    @Override
    public String inspect(List<String> arguments) {
        return this.heroes.get(arguments.get(1)).toString();
    }

    @Override
    public String quit() {
        List<Hero> ordered = this.heroes.values()
                .stream()
                .sorted((h1, h2) -> {
                    long hero1Stats = h1.getStrength() + h1.getAgility() + h1.getIntelligence();
                    long hero2Stats = h2.getStrength() + h2.getAgility() + h2.getIntelligence();

                    long result = hero2Stats - hero1Stats;
                    if (result == 0) {
                        long h1OtherStats = h1.getHitPoints() + h1.getDamage();
                        long h2OtherStats = h2.getHitPoints() + h2.getDamage();
                        result = h2OtherStats - h1OtherStats;
                    }

                    return (int) result;
                })
                .collect(Collectors.toList());

        StringBuilder output = new StringBuilder();
        int index = 1;
        for (Hero hero : ordered) {
            output.append(index).append(". ").append(hero.getClass().getSimpleName()).append(": ").append(hero.getName()).append(System.lineSeparator());
            output.append("###HitPoints: ").append(hero.getHitPoints()).append(System.lineSeparator());
            output.append("###Damage: ").append(hero.getDamage()).append(System.lineSeparator());
            output.append("###Strength: ").append(hero.getStrength()).append(System.lineSeparator());
            output.append("###Agility: ").append(hero.getAgility()).append(System.lineSeparator());
            output.append("###Intelligence: ").append(hero.getIntelligence()).append(System.lineSeparator());

            if (hero.getItems().isEmpty()) {
                output.append("###Items: None");
            } else {
                output.append("###Items: ");
                List<String> items = new ArrayList<>();
                hero.getItems().forEach(item -> items.add(item.getName()));

                output.append(items.toString().replaceAll("[\\[\\]]", "")).append(System.lineSeparator());
            }
            index++;
        }

        return output.toString().trim();
    }
}
