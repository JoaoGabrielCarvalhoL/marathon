package br.com.joaogabriel.concurrency.future.service;

import java.util.concurrent.*;

public class StoreService {

    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public double getPriceSync(String name) {
        System.out.printf("Getting prices Sync for store %s%n", name);
        return priceGenerator();
    }

    private Double priceGenerator() {
        System.out.printf("Generating price by %s%n", Thread.currentThread().getName());
        delay(2);
        return ThreadLocalRandom.current().nextDouble(1, 1000);
    }

    public Future<Double> getPricesAsyncFuture(String name) {
        System.out.printf("Starting with: %d%n", Runtime.getRuntime().availableProcessors());
        System.out.printf("Getting prices Async Future for store %s%n", name);
       return this.executorService.submit(this::priceGenerator);
    }

    public CompletableFuture<Double> getPricesAsyncCompletableFuture(String name) {
        System.out.printf("Getting prices Completable Future for store %s%n", name);
        return CompletableFuture.supplyAsync(this::priceGenerator);
    }

    public void shutdown() {
        this.executorService.shutdown();
    }

    private void delay(long timeout) {
        try{
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
