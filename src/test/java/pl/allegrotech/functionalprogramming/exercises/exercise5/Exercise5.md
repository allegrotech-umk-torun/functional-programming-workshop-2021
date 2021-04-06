### Zadanie 5

W pliku Exercise5.java znajdują się cztery testy jednostkowe operujące na testowej liście faktur. Faktura reprezentowana jest przez klasę Invoice, która zawiera cenę zakupionego produktu razem z jego ilością. W klasie Invoice w polu signatures przechowywana jest też lista podpisów na fakturze.

Twoim zadaniem jest dopisanie kodu spełniającego następujące wymagania:
1. Dla testu shouldTestReducing() dopisz implementację, która wyznaczy sumaryczny koszt zakupów dla wszystkich faktur. Koszt = suma(price * quantity). Wykorzystaj do tego metody map i reduce, którę udostępnia klasa Stream.
2. Dla testu shouldTestGrouping() dopisz implementację, która pogrupuje faktury po ich typie i dla każdej grupy wyznaczy średnią cenę pojedynczego produktu na fakturze. Pierwszy znak pola invoiceId oznacza typ faktury.
3. Dla testu shouldTestFlatMap() dopisz implementację, która wyznaczy ilość podpisów użytkownika "Max Pereira" na wszystkich fakturach.
4. Dla testu shouldTestComparator() dopisz implementację, która znajdzie fakturę z jak najwyższą ceną, która została podpisana przez użytkownika "Max Pereira".