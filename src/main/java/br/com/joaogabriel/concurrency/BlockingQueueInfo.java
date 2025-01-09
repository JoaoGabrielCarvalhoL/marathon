package br.com.joaogabriel.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueInfo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);
        try {
            blockingQueue.put("João Gabriel Carvalho");
            System.out.printf("%s added value { %s } in blocking queue\n", Thread.currentThread().getName(), blockingQueue.peek());

            System.out.println("Trying to add another value in blocking queue");

            /// Will waiting a remove element from a list to insert another one
            blockingQueue.put("Cruz");
            System.out.printf("%s added value { %s } in blocking queue\n", Thread.currentThread().getName(), blockingQueue.peek());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
