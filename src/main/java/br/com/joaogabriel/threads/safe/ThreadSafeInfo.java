package br.com.joaogabriel.threads.safe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class denominated ThreadSafe is a class whose the methods are a synchronized
 * */
public class ThreadSafeInfo {
    public static void main(String[] args) {
        ThreadSafeNames threadSafeNames = new ThreadSafeNames();
        threadSafeNames.add("João Gabriel");
        Runnable runnable = threadSafeNames::removeFirst;
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}

class ThreadSafeNames {
    private final List<String> names = Collections.synchronizedList(new ArrayList<>());

    public synchronized void add(String name) {
        names.add(name);
    }

    /**
     * Must be synchronized because a class thread safe, the methods must be synchronized */
    public synchronized void removeFirst() {
        if (!names.isEmpty()) {
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            System.out.println("names.remove(0) = " + names.removeFirst());
        }
    }
}