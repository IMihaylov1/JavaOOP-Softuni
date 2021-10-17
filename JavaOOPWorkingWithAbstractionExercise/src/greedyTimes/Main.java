package greedyTimes;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long capacityBag = Long.parseLong(scanner.nextLine());
        String[] itemsAndQuantity = scanner.nextLine().split("\\s+");

        Map<String,LinkedHashMap<String,Long>> bag = new LinkedHashMap<>();

        for (int i = 0; i < itemsAndQuantity.length; i += 2) {
            String name = itemsAndQuantity[i];
            long quantity = Long.parseLong(itemsAndQuantity[i + 1]);

            String item = "";

            item = getItem(name, item);

            if (item.equals("")) {
                continue;
            } else if (isNotExceedBag(capacityBag, bag, quantity)) {
                continue;
            }

            if (fillingTheBag(bag, quantity, item)) continue;

            if (!bag.containsKey(item)) {
                bag.put((item), new LinkedHashMap<>());
            }

            if (!bag.get(item).containsKey(name)) {
                bag.get(item).put(name, 0L);
            }

            bag.get(item).put(name, bag.get(item).get(name) + quantity);

        }

        printOutput(bag);
    }


    private static void printOutput(Map<String, LinkedHashMap<String, Long>> bag) {
        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", x.getKey(), sumValues);

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static boolean fillingTheBag(Map<String, LinkedHashMap<String, Long>> bag, long quantity, String item) {
        switch (item) {
            case "Gem":
                if (!bag.containsKey(item)) {
                    if (bag.containsKey("Gold")) {
                        if (isQuantityBiggerThanBagSum(bag, quantity)) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                } else if (isBagPlusQuantityBiggerThanBag(bag, quantity, item)) {
                    return true;
                }
                break;
            case "Cash":
                if (!bag.containsKey(item)) {
                    if (bag.containsKey("Gem")) {
                        if (isQuantityBiggerThanBagSum(bag, quantity)) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                } else if (isGem(bag, quantity, item, "Gem")) {
                    return true;
                }
                break;
        }
        return false;
    }

    private static boolean isGem(Map<String, LinkedHashMap<String, Long>> bag, long quantity, String item, String gem) {
        return bag.get(item).values().stream().mapToLong(e -> e).sum() + quantity > bag.get(gem).values().stream().mapToLong(e -> e).sum();
    }

    private static boolean isBagPlusQuantityBiggerThanBag(Map<String, LinkedHashMap<String, Long>> bag, long quantity, String item) {
        return isGem(bag, quantity, item, "Gold");
    }

    private static boolean isQuantityBiggerThanBagSum(Map<String, LinkedHashMap<String, Long>> bag, long quantity) {
        return quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum();
    }

    private static boolean isNotExceedBag(long capacityBag, Map<String, LinkedHashMap<String, Long>> bag, long quantity) {
        return capacityBag < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + quantity;
    }

    private static String getItem(String name, String item) {
        if (name.length() == 3) {
            item = "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            item = "Gem";
        } else if (name.toLowerCase().equals("gold")) {
            item = "Gold";
        }
        return item;
    }
}
