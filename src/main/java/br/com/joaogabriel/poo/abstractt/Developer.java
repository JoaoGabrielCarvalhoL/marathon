package br.com.joaogabriel.poo.abstractt;

import java.math.BigDecimal;
import java.math.MathContext;

public class Developer extends Employee{
    private String speciality;

    public Developer(String name, BigDecimal salary, String speciality) {
        super(name, salary);
        this.speciality = speciality;
    }

    @Override
    public void bonus() {
       System.out.println(this.getSalary().add(this.getSalary().multiply(new BigDecimal(0.10), MathContext.DECIMAL32)));

    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "speciality='" + speciality + '\'' +
                '}';
    }
}
