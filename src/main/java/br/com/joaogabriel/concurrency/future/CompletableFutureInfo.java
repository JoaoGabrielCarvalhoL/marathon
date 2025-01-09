package br.com.joaogabriel.concurrency.future;

import br.com.joaogabriel.concurrency.future.service.StoreService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFutureInfo {
    private static final StoreService storeService = new StoreService();

    public static void main(String[] args) {
        searchPricesSync();
        searchPricesAsyncFuture();
        searchPricesAsyncCompletableFuture();
    }

    private static void searchPricesSync() {
        long begin = System.currentTimeMillis();
        System.out.println(storeService.getPriceSync("Store 1"));
        System.out.println(storeService.getPriceSync("Store 2"));
        System.out.println(storeService.getPriceSync("Store 3"));
        System.out.println(storeService.getPriceSync("Store 4"));
        System.out.println(storeService.getPriceSync("Store 5"));
        long end = System.currentTimeMillis();
        System.out.printf("searchPricesSync() = Execution in milliseconds: %d%n",  (end - begin));
    }

    private static void searchPricesAsyncFuture() {
        long begin = System.currentTimeMillis();
        Future<Double> pricesAsyncFuture = storeService.getPricesAsyncFuture("Store 1");
        Future<Double> pricesAsyncFuture1 = storeService.getPricesAsyncFuture("Store 2");
        Future<Double> pricesAsyncFuture2 = storeService.getPricesAsyncFuture("Store 3");
        Future<Double> pricesAsyncFuture3 = storeService.getPricesAsyncFuture("Store 4");
        Future<Double> pricesAsyncFuture4 = storeService.getPricesAsyncFuture("Store 5");

        List<Future<Double>> futureList = new ArrayList<>();
        futureList.addAll(Arrays.asList(pricesAsyncFuture, pricesAsyncFuture1, pricesAsyncFuture2,
                pricesAsyncFuture3, pricesAsyncFuture4));

        try {
            for(Future<Double> future : futureList) {
                System.out.println("future.get() = " + future.get());
            }

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            CompletableFutureInfo.storeService.shutdown();
        }

        long end = System.currentTimeMillis();
        System.out.printf("searchPricesAsyncFuture() = Execution in milliseconds: %d%n", (end - begin));
    }

    private static void searchPricesAsyncCompletableFuture() {
        long begin = System.currentTimeMillis();
        CompletableFuture<Double> pricesAsyncFuture = storeService.getPricesAsyncCompletableFuture("Store 1");
        CompletableFuture<Double> pricesAsyncFuture1 = storeService.getPricesAsyncCompletableFuture("Store 2");
        CompletableFuture<Double> pricesAsyncFuture2 = storeService.getPricesAsyncCompletableFuture("Store 3");
        CompletableFuture<Double> pricesAsyncFuture3 = storeService.getPricesAsyncCompletableFuture("Store 4");
        CompletableFuture<Double> pricesAsyncFuture4 = storeService.getPricesAsyncCompletableFuture("Store 5");

        List<CompletableFuture<Double>> futureList = new ArrayList<>();
        futureList.addAll(Arrays.asList(pricesAsyncFuture, pricesAsyncFuture1, pricesAsyncFuture2,
                pricesAsyncFuture3, pricesAsyncFuture4));

        for(CompletableFuture<Double> completableFuture : futureList) {
            System.out.println("completableFuture.get() = " + completableFuture.join());
        }
        long end = System.currentTimeMillis();
        System.out.printf("searchPricesAsyncCompletableFuture() = Execution in milliseconds: %d%n", (end - begin));
    }
}
