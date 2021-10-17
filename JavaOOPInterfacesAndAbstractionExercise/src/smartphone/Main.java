package smartphone;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] callInput= scanner.nextLine().split("\\s+");
        String[] urlInput = scanner.nextLine().split("\\s+");



        Smartphone smartphone = new Smartphone(List.of(callInput),List.of(urlInput));
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());


    }
}
