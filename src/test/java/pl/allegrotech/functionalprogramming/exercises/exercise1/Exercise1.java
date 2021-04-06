package pl.allegrotech.functionalprogramming.exercises.exercise1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise1 {

    @Test
    public void shouldTestMeasuringExecutionTime() {
        // given / when
        String result = "DONE"; // do zaimplementowania, dodaj wywołanie metody measured

        // then
        assertEquals(result, "DONE");
    }

    private String executeBusinessLogic() {
        System.out.println("Doing important thing...");
        return "DONE";
    }
}
