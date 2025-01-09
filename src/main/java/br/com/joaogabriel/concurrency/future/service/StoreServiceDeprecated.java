package br.com.joaogabriel.concurrency.future.service;

import java.util.concurrent.*;

public class StoreServiceDeprecated {

    public double getPriceSync(String name) {
        System.out.printf("Getting prices Sync for store %s%n", name);
        return priceGenerator();
    }

    private Double priceGenerator() {
        System.out.printf("Generating price by %s%n", Thread.currentThread().getName());
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
