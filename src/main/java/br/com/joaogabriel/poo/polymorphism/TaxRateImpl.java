package br.com.joaogabriel.poo.polymorphism;

public class TaxRateImpl implements TaxRate{

    @Override
    public Double taxRate(Product product) {
        if (product instanceof Computer) {
            return product.getPrice() * 0.20;
        }
        else if(product instanceof Keyboard) {
            return product.getPrice() * 0.10;
        } else {
            return 0d;
        }
    }
}
