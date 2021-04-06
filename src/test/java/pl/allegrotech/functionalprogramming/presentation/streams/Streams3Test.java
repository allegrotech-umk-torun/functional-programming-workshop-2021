package pl.allegrotech.functionalprogramming.presentation.streams;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;
import java.util.stream.Stream;

class Streams3Test {

    private static final Supplier<Stream<String>> tokens = () -> Stream.of("d2", "a2", "b1", "b3", "c");

    @Test
    public void shouldTestStreamIsLazy() {
        // when / then
        tokens.get().filter(element -> {
            System.out.println("filter: " + element);
            return element.contains("2");
        });
    }

    @Test
    public void shouldTestInvocationOrderV1() {
        // when / then
        System.out.println("\nFirst run:\n");

        tokens.get()
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));

        // when / then
        System.out.println("\nSecond run:\n");

        tokens.get()
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println();
    }

    @Test
    public void shouldTestInvocationOrderV2() {
        // when / then
        System.out.println("\nFirst run:\n");

        tokens.get()
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        // when / then
        System.out.println("\nSecond run:\n");

        tokens.get()
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println();
    }

}
