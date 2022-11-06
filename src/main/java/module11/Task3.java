package module11;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {
    public static void main(String[] args) {
        String[] array = {"1, 2, 0", "4, 5"};
        System.out.println("convertingAnArrayOfStringsToSortedString(array) = " + convertingAnArrayOfStringsToSortedString(array));
    }
    public static String convertingAnArrayOfStringsToSortedString(String[] arr) {
        Stream<String> stringStream = Stream.of(arr);
        String collect = stringStream.collect(Collectors.joining(", "));
        String[] temp = collect.split(",\s");
        Stream<String> stringStream1 = Stream.of(temp);
        return stringStream1
                .sorted(String::compareTo)
                .collect(Collectors.joining(", "));
    }
}
