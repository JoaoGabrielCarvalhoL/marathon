package br.com.joaogabriel.concurrency.future;

import br.com.joaogabriel.concurrency.future.model.Quote;
import br.com.joaogabriel.concurrency.future.service.StoreServiceWithDiscount;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureWithDiscount {
    public static void main(String[] args) {
        searchPricesWithDiscountSync(new StoreServiceWithDiscount());
        searchPricesWithDiscountAsync(new StoreServiceWithDiscount());
    }

    private static void searchPricesWithDiscountSync(StoreServiceWithDiscount storeService) {
        long begin = System.currentTimeMillis();
        System.out.println("Sync");
        List<String> stores = List.of("Store 1", "Store 2", "Store 3");

        System.out.println("Verifying discount...");

        stores.stream().map(storeService::getPriceSync)
                .map(Quote::newQuote)
                .map(storeService::applyDiscount)
                .forEach(System.out::println);

        long end = System.currentTimeMillis();
        System.out.printf("begin: %d, end: %d: %d milliseconds%n", begin, end, (end - begin));
    }

    private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount storeService) {
        System.out.println("Async");
        long begin = System.currentTimeMillis();
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4", "Store 5",
                "Store 6", "Store 7", "Store 8", "Store 9", "Store 10", "Store 11", "Store 12",
                "Store 13", "Store 14", "Store 15");

        System.out.println("Verifying discount...");

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<CompletableFuture<String>> collected = stores.stream()
                .map(store -> CompletableFuture.supplyAsync(() -> storeService.getPriceSync(store), executorService))
                .map(completableFuture -> completableFuture.thenApply(Quote::newQuote))
                .map(completableFuture ->
                        completableFuture.thenCompose(quote -> CompletableFuture.supplyAsync(() -> storeService.applyDiscount(quote))))
                .collect(Collectors.toList());

        collected.stream().map(CompletableFuture::join).forEach(System.out::println);

        executorService.shutdown();

        long end = System.currentTimeMillis();
        System.out.printf("begin: %d, end: %d: %d milliseconds", begin, end, (end - begin));
    }
}
