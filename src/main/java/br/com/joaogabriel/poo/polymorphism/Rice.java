package br.com.joaogabriel.poo.polymorphism;

import java.time.LocalDate;

public class Rice extends Product{

    private LocalDate expirationDate;

    public Rice(String name, Double price) {
        super(name, price);
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
