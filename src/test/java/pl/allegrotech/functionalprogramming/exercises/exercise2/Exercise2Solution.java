package pl.allegrotech.functionalprogramming.exercises.exercise2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise2Solution {

    private static final List<String> numbers = List.of("1", "2", "3", "4", "5", "6");
    private static final List<String> words = List.of("one", "two", "three", "four", "five", "six");
    private static final List<String> fruits = List.of("apple", "cranberry", "blueberry", "blackberry");

    @Test
    public void shouldTestCollect() {
        // given / when
        List<String> result1 = Predicates.collect(numbers, n -> Integer.parseInt(n) % 2 == 0);
        List<String> result2 = Predicates.collect(words, w -> w.length() == 3);
        List<String> result3 = Predicates.collect(fruits, f -> f.contains("berry"));

        // then
        assertEquals(List.of("2", "4", "6"), result1);
        assertEquals(List.of("one", "two", "six"), result2);
        assertEquals(List.of("cranberry", "blueberry", "blackberry"), result3);
    }

    static class Predicates {

        public static <T> List<T> collect(Collection<T> collection, Predicate<T> predicate) {
            List<T> result = new ArrayList<>();
            for (T element : collection) {
                if (predicate.test(element)) {
                    result.add(element);
                }
            }
            return result;
        }
    }

}
