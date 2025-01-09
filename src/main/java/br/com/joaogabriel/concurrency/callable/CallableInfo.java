package br.com.joaogabriel.concurrency.callable;

import java.util.concurrent.*;

class RandomNumberCallable implements Callable<String> {

    /**
     * Math.random() -> Synchronized (Lock with multiple threads)
     * */

    @Override
    public String call() throws Exception {
        int random = ThreadLocalRandom.current().nextInt(0, 1000);
        for (int i = 0; i < random; i++) {
            System.out.println("random = " + random);
            System.out.printf("%s: %d%n", Thread.currentThread().getName(), i);
        }
        return String.format("%s: %d", Thread.currentThread().getName(), random);
    }
}

public class CallableInfo {
    public static void main(String[] args) {
        RandomNumberCallable randomNumberCallable = new RandomNumberCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> submit = executorService.submit(randomNumberCallable);
        /**
         * get()
         * Waits if necessary for the computation to complete, and then retrieves its result.
         * */
        try {
            String future = submit.get();
            System.out.println(future);
        } catch (CancellationException | InterruptedException | ExecutionException exception) {
            exception.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
