package module11;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        List<String> namesList = List.of("Anton", "Alyona", "Kris", "Tanya", "Polina", "Sasha", "Masha");
        System.out.println("namesByOddIndex(namesList) = " + namesByOddIndex(namesList));

    }

    public static String namesByOddIndex(List<String> names) {
        String result = "";
        for (int i = 0; i < names.size(); i++) {
            if (i % 2 != 0) {
                result += i + ". " + names.get(i) + ",";
            }
        }

        String[] arrNames = result.split(",");
        Stream<String> hashMapStream = Stream.of(arrNames);
        return hashMapStream
                .collect(Collectors.joining(", "));
    }
}
