package br.com.joaogabriel.poo.abstractt;

import java.math.BigDecimal;

public abstract class Employee {
    private String name;
    private BigDecimal salary;

    public Employee(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract void bonus();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
