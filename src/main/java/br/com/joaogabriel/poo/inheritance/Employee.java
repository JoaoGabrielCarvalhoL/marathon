package br.com.joaogabriel.poo.inheritance;

import java.math.BigDecimal;

public class Employee extends Person {
    private BigDecimal salary;

    public Employee() {}

    public Employee(String name, String document, Address address, BigDecimal salary) {
        super(name, document, address);
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void print() {
        super.print();
        System.out.println("Salary: " + this.salary);
    }
}


