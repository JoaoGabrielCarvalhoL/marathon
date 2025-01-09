package br.com.joaogabriel.concurrency.future;

import java.util.concurrent.*;

public class FutureInfo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> currencyService = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(9);
            return ThreadLocalRandom.current().nextDouble();
        });
        System.out.println("sum() = " + sum());
        Double resultFromFuture = currencyService.get(10, TimeUnit.SECONDS);
        System.out.println("resultFromFuture = " + resultFromFuture);
        executorService.shutdown();

    }

    public static long sum() {
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }
        return sum;
    }
}
