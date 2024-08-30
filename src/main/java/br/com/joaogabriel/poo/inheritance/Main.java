package br.com.joaogabriel.poo.inheritance;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Employee employee =
                new Employee("João Gabriel", "11223344",
                        new Address("Rua I", "1234-098"), new BigDecimal(0));
        employee.print();
    }
}
