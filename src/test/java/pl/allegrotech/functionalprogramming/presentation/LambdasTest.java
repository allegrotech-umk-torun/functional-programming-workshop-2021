package pl.allegrotech.functionalprogramming.presentation;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class LambdasTest {

    interface TextConverter {
        String convert(String text);
    }

    @Test
    public void shouldTestLambdaExpression() {
        // given
        String exampleText = " Example text   ";

        // and
        TextConverter anonymousClass = new TextConverter() {

            @Override
            public String convert(String text) {
                return text.replace(' ', '.');
            }

        };

        // and
        TextConverter lambdaExpression = text -> text.replace(' ', '.');

        // when / then
        assertEquals(".Example.text...", anonymousClass.convert(exampleText));
        assertEquals(".Example.text...", lambdaExpression.convert(exampleText));
    }

    @Test
    public void shouldTestPredicate() {
        // given
        Predicate<String> nullCheck = text -> text != null;
        Predicate<String> emptyCheck = text -> text.length() > 0;
        Predicate<String> notNullAndNotEmptyCheck = nullCheck.and(emptyCheck);

        // when / then
        assertTrue(notNullAndNotEmptyCheck.test("Hello"));
        assertFalse(notNullAndNotEmptyCheck.test(""));
        assertFalse(notNullAndNotEmptyCheck.test(null));
    }

    @Test
    public void shouldTestConsumer() {
        // given
        List<String> words = List.of("hello", "world");

        // and
        Consumer<String> printUpperCase = text -> System.out.println(text.toUpperCase());

        // when / then
        words.forEach(printUpperCase);
    }

    @Test
    public void shouldTestFunction() {
        // given
        Function<String, Integer> parseInteger = text -> Integer.parseInt(text);
        Function<Integer, Integer> absoluteValue = value -> Math.abs(value);
        Function<String, Integer> mapToAbsoluteInteger = parseInteger.andThen(absoluteValue);

        // when / then
        assertEquals(1, mapToAbsoluteInteger.apply("-1"));
        assertEquals(1, mapToAbsoluteInteger.apply("1"));
    }

    @Test
    public void shouldTestSupplier() {
        // given
        Supplier<String> generator = () -> {
            var id = new Random().nextInt(100);
            return String.format("User %s", id);
        };

        // when / then
        printMessage(generator);
        printMessage(generator);
        printMessage(generator);
    }

    private void printMessage(Supplier<String> supplier) {
        System.out.println(supplier.get());
    }

}
