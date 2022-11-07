package module11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5 {
    public static void main(String[] args) {
        Stream<Integer> first = Stream.of(1, 9, 3, 87, 45, 11, 65, 42);
        Stream<Integer> second = Stream.of(6, 38, 59, 6, 22, 3);

        zip(first, second).forEach(System.out::println);

    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> list1 = first.collect(Collectors.toList());
        List<T> list2 = second.collect(Collectors.toList());
        int minSize = Math.min(list1.size(), list2.size());
        List<T> result = new ArrayList<>();
        for (int i = 0; i < minSize; i++) {
            result.add(list1.get(i));
            result.add(list2.get(i));
        }
        return result.stream();
    }
}
