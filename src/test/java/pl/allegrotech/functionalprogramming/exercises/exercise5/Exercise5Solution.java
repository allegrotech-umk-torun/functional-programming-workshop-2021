package pl.allegrotech.functionalprogramming.exercises.exercise5;

import org.junit.jupiter.api.Test;
import pl.allegrotech.functionalprogramming.exercises.exercise5.Invoice.Signature;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.math.RoundingMode.HALF_UP;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise5Solution {

    private final List<Invoice> invoices = Arrays.asList(
            new Invoice(
                    "A01",
                    BigDecimal.valueOf(9.5),
                    1,
                    List.of(new Signature("Max Pereira"))
            ),
            new Invoice(
                    "A02",
                    BigDecimal.valueOf(19.5),
                    2,
                    List.of(new Signature("Max Pereira"), new Signature("Dave Lopez"))
            ),
            new Invoice(
                    "B01",
                    BigDecimal.valueOf(4.5),
                    10,
                    List.of(new Signature("Dave Lopez"))
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
        BigDecimal summarizedInvoiceExpenses = invoices.stream()
                .map(invoice -> BigDecimal.valueOf(invoice.getQuantity()).multiply(invoice.getPrice()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // then
        assertEquals(
                BigDecimal.valueOf(238.5).setScale(2, HALF_UP),
                summarizedInvoiceExpenses.setScale(2, HALF_UP)
        );
    }

    @Test
    public void shouldTestGrouping() {
        // given / when
        Map<String, Double> averagePricesGroupedByInvoiceId = invoices.stream()
                .collect(
                        Collectors.groupingBy(
                                invoice -> invoice.getId().substring(0, 1),
                                Collectors.averagingDouble(invoice -> invoice.getPrice().doubleValue())
                        )
                );

        // then
        assertEquals(
                Map.of("A", 14.5, "B", 9.5),
                averagePricesGroupedByInvoiceId
        );
    }

    @Test
    public void shouldTestFlatMap() {
        // given / when
        long numberOfMaxPereiraSignatures = invoices.stream()
                .flatMap(invoice -> invoice.getSignatures().stream())
                .filter(signature -> signature.getValue().equals("Max Pereira"))
                .count();

        // then
        assertEquals(2, numberOfMaxPereiraSignatures);
    }

    @Test
    public void shouldTestComparator() {
        // given / when
        Invoice invoiceWithHighestPriceSignedByMaxPereira = invoices.stream()
                .filter(x -> x.getSignatures().stream().anyMatch(y -> y.getValue().equals("Max Pereira")))
                .max(Comparator.comparing(Invoice::getPrice))
                .orElseThrow();

        // then
        assertEquals(invoiceWithHighestPriceSignedByMaxPereira.getPrice(), BigDecimal.valueOf(19.5));
    }

}

