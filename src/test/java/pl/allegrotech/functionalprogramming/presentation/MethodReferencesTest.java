package pl.allegrotech.functionalprogramming.presentation;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MethodReferencesTest {

    @Test
    public void shouldTestMethodReferenceViaConstructor() {
        // given
        Function<String, Person> createPerson = Person::new;

        // when
        Person person = createPerson.apply("Bolek");

        // then
        assertEquals("Bolek", person.getName());
    }

    @Test
    public void shouldTestMethodReferenceViaStaticMethod() {
        // given
        Function<String, String> convertToUppercase = MethodReferencesTest::toUpperCase;

        // when
        String result = convertToUppercase.apply("Bolek");

        // then
        assertEquals("BOLEK", result);
    }

    @Test
    public void shouldTestMethodReferenceViaInstanceMethodOfClass() {
        // given
        Function<String, String> convertToUppercase = String::toUpperCase;

        // when
        String result = convertToUppercase.apply("Bolek");

        // then
        assertEquals("BOLEK", result);
    }

    @Test
    public void shouldTestMethodReferenceViaInstanceMethod() {
        // given
        Set<String> knownNames = Set.of("Bolek", "Lolek", "Tola");
        Predicate<String> isKnown = knownNames::contains;

        // when
        boolean result = isKnown.test("Bolek");

        // then
        assertTrue(result);
    }

    static class Person {

        private final String name;

        Person(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }

    private static String toUpperCase(String text) {
        return text.toUpperCase();
    }

}
