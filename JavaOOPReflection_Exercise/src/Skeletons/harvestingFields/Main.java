package Skeletons.harvestingFields;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
		Field[] fields = RichSoilLand.class.getDeclaredFields();
        while (!input.equals("HARVEST")) {
			for (Field field : fields) {
				String modifierName = Modifier.toString(field.getModifiers());
				if(input.equals(modifierName)||input.equals("all")){
					System.out.printf("%s %s %s%n",modifierName,field.getType().getSimpleName(),field.getName());
				}
			}
            input = scanner.nextLine();
        }
    }
}
