package pl.allegrotech.functionalprogramming.presentation.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Streams1Test {

    @Test
    public void shouldTestCreatingStream() {
        // 1st method
        System.out.println("Stream created by stream(): ");
        List<String> list = List.of("l1", "l2", "l3");
        list.stream().forEach(System.out::println);

        // 2nd method
        System.out.println("Stream created by Arrays.stream(): ");
        String[] array = new String[]{"a1", "a2", "a3"};
        Arrays.stream(array).forEach(System.out::println);

        // 3rd method
        System.out.println("Stream created by StreamBuilder: ");

        Stream<String> builder = Stream.<String>builder()
                .add("b1")
                .add("b2")
                .add("b3")
                .build();
        builder.forEach(System.out::println);

        // 4th method
        System.out.println("Stream created by Stream.of(): ");
        Stream.of("s1", "s2", "s3").forEach(System.out::println);

        // 5th method
        System.out.println("Stream created by IntStream.range(): ");
        IntStream.range(3, 10).forEach(System.out::println);

        // 6th method
        System.out.println("Stream created by Stream.generate(): ");
        Stream<String> generated = Stream.generate(() -> "element").limit(10);
        generated.forEach(System.out::println);

        // 7th method
        System.out.println("Stream created by Stream.iterate(): ");
        Stream<Integer> iterated = Stream.iterate(40, n -> n + 2).limit(10);
        iterated.forEach(System.out::println);
    }

}
