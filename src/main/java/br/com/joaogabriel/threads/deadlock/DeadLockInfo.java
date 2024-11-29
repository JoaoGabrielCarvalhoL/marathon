package br.com.joaogabriel.threads.deadlock;

/**
 * Deadlock occurs with a set of non-preemptible processes and resources,
 *  where one or more processes in this set are waiting for the release of a resource by another process, which,
 *  in turn, is waiting for the release of another resource allocated or dependent on the first process.
 * */
public class DeadLockInfo {
    /**
     * Example of DeadLock
     * */
    public static void main(String[] args) {
        final Object firstObject = new Object();
        final Object secondObject = new Object();
        Runnable firstRunnable = () -> {
            synchronized (firstObject) {
                System.out.println("First Thread: Lock firstObject");
                System.out.println("First Thread: Awaiting secondObject");
                synchronized (secondObject) {
                    System.out.println("First Thread: Locking secondObject");
                }
            }
        };

        Runnable secondRunnable = () -> {
            synchronized (secondObject) {
                System.out.println("Second Thread: Lock secondObject");
                System.out.println("Second Thread: Awaiting firstObject");
                synchronized (firstObject) {
                    System.out.println("Second Thread: Locking firstObject");
                }
            }
        };

        new Thread(firstRunnable, "First Thread").start();
        new Thread(secondRunnable, "Second Thread").start();
    }
}
