package module11;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {
        List<String> namesList = List.of("Anton", "Alyona", "Kris", "Tanya", "Polina", "Sasha", "Masha");
        System.out.println("listOfStringsInUppercaseAndSortedInDescendingOrder(namesList) = " + listOfStringsInUppercaseAndSortedInDescendingOrder(namesList));
    }

    public static String listOfStringsInUppercaseAndSortedInDescendingOrder(List<String> names) {
        Stream<String> streamNames = names.stream();
        return streamNames
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(", "));
    }
}
