package pl.allegrotech.functionalprogramming.exercises.exercise5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.math.RoundingMode.HALF_UP;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class Exercise5 {

    private final List<Invoice> invoices = Arrays.asList(
            new Invoice(
                    "A01",
                    BigDecimal.valueOf(9.5),
                    1,
                    List.of(new Invoice.Signature("Max Pereira"))
            ),
            new Invoice(
                    "A02",
                    BigDecimal.valueOf(19.5),
                    2,
                    List.of(new Invoice.Signature("Max Pereira"), new Invoice.Signature("Dave Lopez"))
            ),
            new Invoice(
                    "B01",
                    BigDecimal.valueOf(4.5),
                    10,
                    List.of(new Invoice.Signature("Dave Lopez"))
            ),
            new Invoice(
                    "B02",
                    BigDecimal.valueOf(14.5),
                    10
            )
    );

    @Test
    public void shouldTestReducing() {
        // given / when
        BigDecimal summarizedInvoiceExpenses = null; // do zaimplementowania, użyj zmiennej invoices

        // then
        assertEquals(
                BigDecimal.valueOf(238.5).setScale(2, HALF_UP),
                summarizedInvoiceExpenses.setScale(2, HALF_UP)
        );
    }

    @Test
    public void shouldTestGrouping() {
        // given / when
        Map<String, Double> averagePricesGroupedByInvoiceId = null; // do zaimplementowania, użyj zmiennej invoices

        // then
        assertEquals(Map.of("A", 14.5, "B", 9.5), averagePricesGroupedByInvoiceId);
    }

    @Test
    public void shouldTestFlatMap() {
        // given / when
        long numberOfMaxPereiraSignatures = -1; // do zaimplementowania, użyj zmiennej invoices

        // then
        assertEquals(2, numberOfMaxPereiraSignatures);
    }

    @Test
    public void shouldTestComparator() {
        // given / when
        Invoice invoiceWithHighestPriceSignedByMaxPereira = null; // do zaimplementowania, użyj zmiennej invoices

        // then
        assertEquals(invoiceWithHighestPriceSignedByMaxPereira.getPrice(), BigDecimal.valueOf(19.5));
    }

}
