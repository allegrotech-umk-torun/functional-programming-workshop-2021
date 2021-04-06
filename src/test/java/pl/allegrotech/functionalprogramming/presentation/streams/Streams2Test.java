package pl.allegrotech.functionalprogramming.presentation.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Streams2Test {

    static class Driver {

        private final String name;
        private final int age;
        private final List<Car> cars;

        Driver(String name, int age, List<Car> cars) {
            this.name = name;
            this.age = age;
            this.cars = cars;
        }

        String getName() {
            return name;
        }

        int getAge() {
            return age;
        }

        List<Car> getCars() {
            return cars;
        }
    }

    static class Car {

        private final String name;

        Car(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }

    List<Car> cars = List.of(new Car("Audi"), new Car("BMW"), new Car("Ferrari"));

    Driver max = new Driver("Max", 18, cars);
    Driver peter = new Driver("Peter", 23, cars);
    Driver pamela = new Driver("Pamela", 23, cars);
    Driver david = new Driver("David", 12, cars);

    List<Driver> drivers = Arrays.asList(max, peter, pamela, david);

    @Test
    public void shouldTestFlatMap() {
        // when
        List<String> distinctCarNames = drivers.stream()
                .flatMap(driver -> driver.cars.stream())
                .map(Car::getName)
                .distinct()
                .collect(Collectors.toList());

        // then
        assertEquals(List.of("Audi", "BMW", "Ferrari"), distinctCarNames);
    }

    @Test
    public void shouldTestGroupingCollector() {
        // given / when
        Map<Integer, List<Driver>> driversGroupedByAge = drivers.stream()
                .collect(Collectors.groupingBy(Driver::getAge));

        // then
        assertEquals(
                Map.of(23, List.of(peter, pamela), 18, List.of(max), 12, List.of(david)),
                driversGroupedByAge
        );
    }

    @Test
    public void shouldTestReducing() {
        // given / when
        Optional<Driver> oldestDriver = drivers.stream()
                .reduce((driver1, driver2) -> driver1.getAge() > driver2.getAge() ? driver1 : driver2);

        // then
        assertTrue(oldestDriver.filter(driver -> List.of(peter, pamela).contains(driver)).isPresent());
    }

}
