package br.com.joaogabriel.concurrency.executors;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Printer implements Runnable {

    private final Integer number;

    public Printer(Integer number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.printf("%s started in: %d\n", Thread.currentThread().getName(), number);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            System.out.printf("%s finished in: %d\n", Thread.currentThread().getName(), number);
        }
    }
}

public class ExecutorsInfo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new Printer(1));
        executorService.execute(new Printer(2));
        executorService.execute(new Printer(3));
        executorService.execute(new Printer(4));
        executorService.execute(new Printer(5));

        executorService.shutdown();
        System.out.println("End program");
    }
}
