package br.com.joaogabriel.concurrency.future.service.test;

import br.com.joaogabriel.concurrency.future.service.StoreService;
import br.com.joaogabriel.concurrency.future.service.StoreServiceDeprecated;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureDeprecated {
    public static void main(String[] args) {
        StoreServiceDeprecated storeServiceDeprecated = new StoreServiceDeprecated();
        searchPricesAsyncCompletableFutureDeprecated(storeServiceDeprecated);
    }

    private static void searchPricesAsyncCompletableFutureDeprecated(StoreServiceDeprecated storeServiceDeprecated) {
        long begin = System.currentTimeMillis();
        List<String> stores = List.of("Store 1","Store 2", "Store 3", "Store 4", "Store 5",
                "Store 6", "Store 7", "Store 8", "Store 9", "Store 10");

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(),
                runnable -> {
                    Thread thread = new Thread(runnable);
                    thread.setDaemon(true);
                    return thread;
                });

        List<CompletableFuture<Double>> completableFutureList = stores.stream()
                .map(sup -> CompletableFuture.supplyAsync(() -> storeServiceDeprecated.getPriceSync(sup), executorService))
                .collect(Collectors.toList());

        List<Double> collected = completableFutureList.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        executorService.shutdown();
        collected.forEach(System.out::println);


        long end = System.currentTimeMillis();
        System.out.printf("searchPricesAsyncCompletableFuture() = Execution in milliseconds: %d%n", (end - begin));

    }
}
