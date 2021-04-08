package pl.allegrotech.functionalprogramming.exercises.exercise3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise3Solution {

    private static final List<String> words = Arrays.asList("One", "Abc", "BCD");

    @Test
    public void shouldTestCompareInDirection() {
        // given
        Comparator<String> descendingComparator = compareInDirection(-1);
        Comparator<String> ascendingComparator = compareInDirection(1);

        // when
        words.sort(descendingComparator);

        // then
        assertEquals(List.of("One", "BCD", "Abc"), words);

        // when
        words.sort(ascendingComparator);

        // then
        assertEquals(List.of("Abc", "BCD", "One"), words);
    }

    @Test
    public void shouldTestReversingComparator() {
        // given
        Comparator<String> originalComparator = String::compareTo;
        Comparator<String> reversedComparator = reverse(originalComparator);

        // when
        words.sort(originalComparator);

        // then
        assertEquals(List.of("Abc", "BCD", "One"), words);

        // when
        words.sort(reversedComparator);

        // then
        assertEquals(List.of("One", "BCD", "Abc"), words);
    }

    private static Comparator<String> compareInDirection(int direction) {
        return (x, y) -> direction * x.compareTo(y);
    }

    public static Comparator<String> reverse(Comparator<String> comparator) {
        return (x, y) -> comparator.compare(y, x);
    }

}

