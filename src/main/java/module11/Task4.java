package module11;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11;
        long m = 2^48;


        linearCongruentGenerator(a, c, m)
                .forEach(System.out::println);
    }

    public static Stream<Long> linearCongruentGenerator(Long a, Long c, Long m) {
        return Stream
                .iterate(1L, (seed) -> (a * seed + c) % m)
                .limit(10);
    }
}
