package br.com.joaogabriel.concurrency;


import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 *  LinkedTransferQueue =  ConcurrentLinkedQueue + SynchronousQueue + LinkedBlockingQueue
 * */
public class LinkedTransferQueueInfo {
    public static void main(String[] args) throws InterruptedException {
        TransferQueue<Object> transferQueue = new LinkedTransferQueue<>();
        System.out.println(transferQueue.add("João"));
        /**
         * add()
         * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
         * Return true upon success and throwing an IllegalStateException if no space is currently available.
         * */
        System.out.println(transferQueue.remainingCapacity());

        System.out.println(transferQueue.offer("Cruz", 10, TimeUnit.SECONDS));
        /**
         * offer()
         * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
         * Return true upon success and false if no space is currently available.
         * */

        transferQueue.put("Carvalho");
        /**
         * Inserts the specified element into this queue, waiting if necessary for space to become available.
         * */

        if (transferQueue.hasWaitingConsumer()) {
            transferQueue.transfer("");
        }
        /**
         * hasWaitingConsumer()
         * Returns true if there is at least one consumer waiting to receive an element via take or timed poll. The return value represents a momentary state of affairs
         *
         * transfer()
         * Transfers the element to a consumer, waiting if necessary to do so.
         * More precisely, transfers the specified element immediately if there exists a consumer already waiting to receive it (in take or timed poll), else waits until the element is received by a consumer.
         * */

        Object element = transferQueue.element();
        System.out.println(element);
        /**
         * element()
         * Retrieves, but does not remove, the head of this queue.
         * This method differs from peek() only in that throws and exception if this queue is empty.
         * */

        Object peek = transferQueue.peek();
        System.out.println("peek = " + peek);
        /**
         * peek()
         * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
         * */

        Object poll = transferQueue.poll();
        System.out.println("poll = " + poll);
        /**
         * Retrieves and removes the head of this queue, or returns null if this queue is empty
         * */

        Object removed = transferQueue.remove();
        System.out.println("removed = " + removed);
        /**
         * Retrieves and removes the head of this queue. This method differs from poll() only in that it throws an exception if this queue is empty.
         * */
    }
}
