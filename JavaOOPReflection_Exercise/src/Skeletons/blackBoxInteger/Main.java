package Skeletons.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Method> stringMethodMap = new HashMap<>();

        Constructor<?>[] declaredConstructors = BlackBoxInt.class.getDeclaredConstructors();
        BlackBoxInt blackBoxInt = null;
        try {
            Constructor<BlackBoxInt> declaredConstructor = BlackBoxInt.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            blackBoxInt = (BlackBoxInt) declaredConstructor.newInstance();
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Method[] declaredMethods = blackBoxInt.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            stringMethodMap.put(declaredMethod.getName(), declaredMethod);
        }


        while (!input.equals("END")) {
            String[] tokens = input.split("_");
            Method method = stringMethodMap.get(tokens[0]);
            method.setAccessible(true);
            method.invoke(blackBoxInt, Integer.parseInt(tokens[1]));


          Field field =  blackBoxInt.getClass().getDeclaredField("innerValue");
          field.setAccessible(true);
            System.out.println(field.get(blackBoxInt));


            input = scanner.nextLine();
        }

    }
}
