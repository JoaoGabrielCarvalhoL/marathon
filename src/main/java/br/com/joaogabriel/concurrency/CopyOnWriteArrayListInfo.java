package br.com.joaogabriel.concurrency;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * When work with immutable class on java, in most's cases, is a final class.
 * Each attribute in this class must be unmodified. There are no setter methods.
 * */

final class Anime {
    private final String name;

    public Anime(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class CopyOnWriteArrayListInfo {
    public static void main(String[] args) {
        List<Integer> numbers = new CopyOnWriteArrayList<>();
        /**
         * With each element added or removed is created a new list and the values copied.
         * When the value is an Object, it's import that the attribute be immutable.
         * */
        for (int i = 0; i < 2000; i++) {
            numbers.add(i);
        }

        Runnable runnable = () -> {
            Iterator<Integer> iterator = numbers.iterator();
            try {
                TimeUnit.SECONDS.sleep(2);
                iterator.forEachRemaining(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable runnableRemover = () -> {
            for (int i = 0; i < 500; i++) {
                System.out.printf("%s removed %d\n", Thread.currentThread().getName(), i);
                numbers.remove(i);
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnableRemover).start();
    }
}
