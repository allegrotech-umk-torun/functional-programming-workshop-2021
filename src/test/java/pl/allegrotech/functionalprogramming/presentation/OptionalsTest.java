package pl.allegrotech.functionalprogramming.presentation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class OptionalsTest {

    @Test
    public void shouldTestCreatingOptional() {
        // given
        Optional<String> optional1 = Optional.empty();
        Optional<String> optional2 = Optional.ofNullable(null);
        Executable optional3 = () -> Optional.of(null);
        Optional<String> optional4 = Optional.of("test");

        // when / then
        assertFalse(optional1.isPresent());

        // and
        assertFalse(optional2.isPresent());

        // and
        assertThrows(NullPointerException.class, optional3);

        // and
        assertTrue(optional4.isPresent());
    }

    @Test
    public void shouldTestIfPresent() {
        // given
        Optional<String> optional1 = Optional.empty();
        Optional<String> optional2 = Optional.of("lorem ipsum dolorosa");

        // and
        Consumer<String> consumer = text -> System.out.println("Length of '" + text + "' is " + text.length());

        // when / then
        optional1.ifPresent(consumer);
        optional2.ifPresent(consumer);
    }

    @Test
    public void shouldTestGettingValue() {
        // given / when
        String value1 = Optional.of("value").get();
        String value2 = Optional.of("value").orElse("default");
        String value3 = Optional.<String>empty().orElse("default");
        Executable value4 = () -> Optional.empty().orElseThrow();
        Executable value5 = () -> Optional.ofNullable(null).get();

        // then
        assertEquals("value", value1);
        assertEquals("value", value2);
        assertEquals("default", value3);
        assertThrows(NoSuchElementException.class, value4);
        assertThrows(NoSuchElementException.class, value5);
    }

    @Test
    public void shouldTestFilteringValue() {
        // given
        Optional<String> optional = Optional.of("lorem ipsum dolorosa");

        // when
        boolean result = optional
                .filter(value -> value.split(" ").length == 3)
                .isPresent();

        // then
        assertTrue(result);
    }

    @Test
    public void shouldTestMappingValue() {
        // given
        Optional<String> optional = Optional.of("lorem ipsum dolorosa");

        // when
        Optional<String> result = optional.map(String::toUpperCase);

        // then
        assertEquals("LOREM IPSUM DOLOROSA", result.get());
    }

    @Test
    public void shouldTestFlatMappingValue() {
        // given
        Optional<Double> optional = Optional.of(16.0);

        // when
        Optional<Double> result = optional.flatMap(this::squareRoot);

        // then
        assertEquals(4.0, result.get());
    }

    private Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }

}
