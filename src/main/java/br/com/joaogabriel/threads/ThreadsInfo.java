package br.com.joaogabriel.threads;


/**
 * Threads
 * Object | Process
 * Threads types:
 * - Daemon: Threads with lower priority. Ends when thread type user is finished.
 *
 * - User: Finished the program when all threads of type user were terminated.
 *
 * Stages of thread:
 *  New ->
 *  Runnable -> Running -> (Waiting/Blocked) -> Runnable -> ***
 *  Running -> Dead
 * */
public class ThreadsInfo {
    public static void main(String[] args) {
        /***
         * Every Thread has a name. Can be passed through the constructor
         */

        /**
         * Thread have priority: 1 to 10. The 5 is default.
         * 1: lower priority
         * 2: higher priority
         * */
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        ThreadExample firstThread = new ThreadExample('i');
        ThreadExample secondThread = new ThreadExample('a');
        ThreadExample thirdThread = new ThreadExample('j');
        ThreadExample fourthThread = new ThreadExample('l');
        Thread fifthThread = new Thread(new ThreadExampleRunnable('q'));
        /**
         * Indicate to scheduler that this thread has a higher priority. But this is not guaranteed
         * */
        firstThread.setPriority(Thread.MAX_PRIORITY);
        secondThread.setPriority(Thread.NORM_PRIORITY);
        thirdThread.setPriority(Thread.MIN_PRIORITY);
        firstThread.start();
        secondThread.start();
        thirdThread.start();
        fourthThread.start();
        fifthThread.start();
    }
}

class ThreadExample extends Thread {
    private char character;

    @Override
    public void run() {
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++) {
            System.out.print("character = " + character + " ");
            if (i % 100 == 0) {
                System.out.println();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

    public ThreadExample(char character) {
        this.character = character;
    }
}

class ThreadExampleRunnable implements Runnable {

    private char character;

    public ThreadExampleRunnable(char character) {
        this.character = character;
    }

    @Override
    public void run() {
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++) {
            System.out.print("character = " + character + " ");
            if (i % 100 == 0) {
                System.out.println();
            }
        }
    }
}