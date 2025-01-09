package br.com.joaogabriel.concurrency.future;

import br.com.joaogabriel.concurrency.future.service.StoreService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureStreamsInfo {
    public static void main(String[] args) {
        searchPricesAsyncCompletableFuture(new StoreService());
    }

    private static void searchPricesAsyncCompletableFuture(StoreService storeService) {
        long begin = System.currentTimeMillis();
        List<String> stores = List.of("Store 1","Store 2", "Store 3", "Store 4", "Store 5");

//        List<Double> numbers = stores.stream()
//                .parallel()
//                .map(storeService::getPricesAsyncCompletableFuture)
//                .map(CompletableFuture::join)
//                .collect(Collectors.toList());
//        numbers.forEach(System.out::println);

        List<CompletableFuture<Double>> list = stores.stream()
                .map(storeService::getPricesAsyncCompletableFuture)
                .toList();
        List<Double> numbers = list.stream().map(CompletableFuture::join)
                .toList();
        numbers.forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.out.printf("searchPricesAsyncCompletableFuture() = Execution in milliseconds: %d%n", (end - begin));

    }
}
