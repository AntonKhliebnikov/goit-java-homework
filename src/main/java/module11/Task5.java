package module11;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5 {
    public static void main(String[] args) {
        Stream<Integer> first = Stream.of(1, 9, 3, 87, 45, 12);
        Stream<Integer> second = Stream.of(6, 38, 59, 6, 22, 3, 11, 64);

        zip(first, second).forEach(System.out::println);

    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iterator = first.iterator();
        return second.flatMap(i ->
        {
            if (iterator.hasNext()) {
                return Stream.of(i, iterator.next());
            } else {
                return Stream.empty();
            }
        });
    }
}
