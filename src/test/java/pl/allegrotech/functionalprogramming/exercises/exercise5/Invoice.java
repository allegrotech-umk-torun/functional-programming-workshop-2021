package pl.allegrotech.functionalprogramming.exercises.exercise5;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

class Invoice {

    private final String id;
    private final BigDecimal price;
    private final int quantity;
    private final List<Signature> signatures;

    Invoice(String id, BigDecimal price, int quantity, List<Signature> signatures) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.signatures = signatures;
    }

    Invoice(String id, BigDecimal price, int quantity) {
        this(id, price, quantity, List.of());
    }

    String getId() {
        return id;
    }

    BigDecimal getPrice() {
        return price;
    }

    int getQuantity() {
        return quantity;
    }

    List<Signature> getSignatures() {
        return signatures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return quantity == invoice.quantity && id.equals(invoice.id) && price.equals(invoice.price) && signatures.equals(invoice.signatures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, quantity, signatures);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", signatures=" + signatures +
                '}';
    }

    static class Signature {

        private final String value;

        Signature(String value) {
            this.value = value;
        }

        String getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Signature signature = (Signature) o;
            return value.equals(signature.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "Signature{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
}
