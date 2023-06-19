package test;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
//        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
//                .reduce(10, (a, b) -> a + b, (a, b) -> {
//                    System.out.println("combiner was called");
//                    return a + b;
//                });
        int reduced =
//                IntStream.range(1, 4).reduce((a, b) -> a + b);
                IntStream.range(1, 4).reduce(Integer::sum).orElseGet(Main::test);
        System.out.println("reducedParallel = " + reduced);
    }

    public static Integer test() {
        System.out.println("elseGet 발동");
        return null;
    }
}
