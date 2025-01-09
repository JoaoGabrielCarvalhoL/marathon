package br.com.joaogabriel.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * */
public class AtomicIntegerInfo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Runnable runnable = () -> {
            for (int i = 0; i < 10_000; i++) {
                counter.increment();
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        System.out.println("counter.getCount() = " + counter.getCount());
        System.out.println("counter.getAtomicInteger() = " + counter.getAtomicInteger());
    }
}

class Counter {
    private int count;
    /**
     * No need to use synchronized with AtomicInteger
     * */
    private final AtomicInteger atomicInteger = new AtomicInteger();
    /**
     * Lock: Interface
     * ReentrantLock: Class
     *
     * Difference between Lock and synchronized:
     *
     * When using synchronized, don't have so much control, managed by JVM.
     * When we use constructor of class ReentrantLock with boolean parameter,
     *  this is mean that Thread awaiting more time will receive priority to lock.
     *
     *  lock.tryLock(3, TimeUnit.SECONDS): Attempt to receive lock.
     *
     *  Possibility of interrupting a thread that is waiting to lock
     * */
    private Lock lock = new ReentrantLock(true);
    void increment() {
        this.count++;
        this.atomicInteger.incrementAndGet();
    }

    public int getCount() {
        return count;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }
}
