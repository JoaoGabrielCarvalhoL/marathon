package br.com.joaogabriel.poo.abstractt;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Developer developer = new Developer("Babidi", new BigDecimal(1000), "Help Majin Boo");
        developer.bonus();
    }
}
