package br.com.joaogabriel.concurrency;

import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable {

    private String name;
    private ReentrantLock lock;

    public Worker(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            if (lock.isHeldByCurrentThread()) {
                System.out.printf("Thread %s critical session", name);
                System.out.println();
            }
            System.out.println("lock.getQueueLength() = " + lock.getQueueLength());
            System.out.println("Thread " + this.name + " will waiting 2 seconds");
            Thread.sleep(2000);
            System.out.println("After two seconds, the waiting is over: " + this.name);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class LockInfo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        new Thread(new Worker("A", lock)).start();
        new Thread(new Worker("B", lock)).start();
        new Thread(new Worker("C", lock)).start();
        new Thread(new Worker("D", lock)).start();
        new Thread(new Worker("E", lock)).start();
        new Thread(new Worker("F", lock)).start();
        new Thread(new Worker("G", lock)).start();
    }
}
