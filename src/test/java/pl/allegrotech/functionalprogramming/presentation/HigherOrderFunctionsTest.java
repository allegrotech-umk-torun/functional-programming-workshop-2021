package pl.allegrotech.functionalprogramming.presentation;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HigherOrderFunctionsTest {

    private int multiplyByTen(int number) {
        return 10 * number;
    }

    private Supplier<Integer> doTwice(Function<Integer, Integer> func, int number) {
        Function<Integer, Integer> newFunc = func.andThen(func);
        return () -> {
            int result = newFunc.apply(number);
            System.out.println("Result: " + result);
            return result;
        };
    }

    @Test
    public void shouldTestHigherOrderFunction() {
        // given
        Function<Integer, Integer> func = this::multiplyByTen;

        // when
        int result = doTwice(func, 2).get();

        // then
        assertEquals(200, result);
    }

}
