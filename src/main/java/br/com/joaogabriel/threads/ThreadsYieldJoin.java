package br.com.joaogabriel.threads;

public class ThreadsYieldJoin {
    public static void main(String[] args) {
        System.out.println("ThreadsYieldJoin.main");
        Thread thread = new Thread(() -> {
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            System.out.println("Thread.currentThread().getPriority() = " + Thread.currentThread().getPriority());
            System.out.println("Thread.currentThread().getState() = " + Thread.currentThread().getState());
            for (int i = 0; i < 500; i++) {
                if (i % 5 == 0) {
                    System.out.println("i = " + i);
                }
                /**
                 * A hint to the scheduler that the current thread is willing to yield its current use of a processor.
                 * The scheduler is free to ignore this hint.
                 * */
                Thread.yield();
            }
        });

        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();

        Thread secondThread = new Thread(() -> {
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            System.out.println("Thread.currentThread().getPriority() = " + Thread.currentThread().getPriority());
            System.out.println("Thread.currentThread().getState() = " + Thread.currentThread().getState());
            for (int i = 0; i < 500; i++) {
                if (i % 5 == 0) {
                    System.out.println("i = " + i);
                }
            }
        });
        secondThread.setPriority(Thread.NORM_PRIORITY);
        secondThread.start();

        Thread thirdThread = new Thread(() -> {
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            System.out.println("Thread.currentThread().getPriority() = " + Thread.currentThread().getPriority());
            System.out.println("Thread.currentThread().getState() = " + Thread.currentThread().getState());
            for (int i = 0; i < 500; i++) {
                if (i % 5 == 0) {
                    System.out.println("i = " + i);
                }
            }
        });
        thirdThread.setPriority(Thread.NORM_PRIORITY);
        try {
            secondThread.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        thirdThread.start();
    }
}
