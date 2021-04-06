package pl.allegrotech.functionalprogramming.exercises.exercise2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise2 {

    private static final List<String> numbers = List.of("1", "2", "3", "4", "5", "6");
    private static final List<String> words = List.of("one", "two", "three", "four", "five", "six");
    private static final List<String> fruits = List.of("apple", "cranberry", "blueberry", "blackberry");

    @Test
    public void shouldTestCollect() {
        // given / when
        List<String> result1 = null; // do zaimplementowania, wykorzystaj zmienną numbers
        List<String> result2 = null; // do zaimplementowania, wykorzystaj zmienną words
        List<String> result3 = null; // do zaimplementowania, wykorzystaj zmienną fruits

        // then
        assertEquals(List.of("2", "4", "6"), result1);
        assertEquals(List.of("one", "two", "six"), result2);
        assertEquals(List.of("cranberry", "blueberry", "blackberry"), result3);
    }

    static class Predicates {

        public static <T> List<T> collect(Collection<T> collection, Predicate<T> predicate) {
            // do zaimplementowania
            return null;
        }
    }

}

