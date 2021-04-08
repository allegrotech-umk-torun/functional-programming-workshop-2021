package pl.allegrotech.functionalprogramming.exercises.exercise1;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise1Solution {

    @Test
    public void shouldTestMeasuringExecutionTime() {
        // given / when
        String result = measured(this::executeBusinessLogicV1);

        // then
        assertEquals(result, "DONE");
    }

    private String executeBusinessLogicV1() {
        System.out.println("Doing important thing...");
        return "DONE";
    }

    private <T> T measured(Supplier<T> supplier) {
        long startTime = System.currentTimeMillis();
        T result = supplier.get();
        System.out.println("Execution time: " + (System.currentTimeMillis() - startTime));
        return result;
    }

}
