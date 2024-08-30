package br.com.joaogabriel.poo.polymorphism;

public class Main {
    public static void main(String[] args) {

        /**
         * Widening Casting
         * */
        Product product = new Computer("Dell G15", 8500d);
        Product prod = new Keyboard("Redragon", 300d);
        TaxRateImpl taxRate = new TaxRateImpl();
        System.out.println(taxRate.taxRate(product));
        System.out.println(taxRate.taxRate(prod));

        /**
         * Narrowing Casting
         * Rice rice = (Rice) new Product("Rice", 30.0d);
         * ClassCastException?
         * */


    }
}
