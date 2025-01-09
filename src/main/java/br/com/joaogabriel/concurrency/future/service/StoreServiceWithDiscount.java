package br.com.joaogabriel.concurrency.future.service;

import br.com.joaogabriel.concurrency.future.model.Discount;
import br.com.joaogabriel.concurrency.future.model.Quote;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class StoreServiceWithDiscount {

    public String getPriceSync(String name) {
        Double price = priceGenerator();
        Discount.Code discount = Discount.Code.values()[
                ThreadLocalRandom.current().nextInt(0, Discount.Code.values().length)];
        return String.format(Locale.of("pt", "BR"),"%s:%.2f:%s", name, price, discount);
    }

    public String applyDiscount(Quote quote) {
        delay(2);
        if (quote.getDiscountCode().equals(Discount.Code.NONE)) {
            return String.format("%s:%.2f:%s", quote.getStore(), quote.getPrice(), quote.getDiscountCode());
        }
        double discount = (((double) quote.getDiscountCode().getPercentage() /100) * quote.getPrice());
        double adjustedPrice = quote.getPrice() - discount;
        return String.format("%s original price: '%.2f'. Applying discount code '%s'. Final price: %.2f",
                quote.getStore(), quote.getPrice(), quote.getDiscountCode(), adjustedPrice);
    }



    private Double priceGenerator() {
        delay(2);
        return ThreadLocalRandom.current().nextDouble(1, 1000);
    }


    private void delay(long timeout) {
        try{
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
