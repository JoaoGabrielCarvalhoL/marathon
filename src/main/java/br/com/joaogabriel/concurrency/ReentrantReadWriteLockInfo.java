package br.com.joaogabriel.concurrency;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock
 * Control writes and reads in the same object.
 * */
class MapReadWrite {
    private final Map<String, String> map = new LinkedHashMap<>();
    private final ReentrantReadWriteLock reentrantReadWriteLock;

    public MapReadWrite(ReentrantReadWriteLock reentrantReadWriteLock) {
        this.reentrantReadWriteLock = reentrantReadWriteLock;
    }

    public void add(String key, String value) {
        reentrantReadWriteLock.writeLock().lock();
        try {
            if (reentrantReadWriteLock.isWriteLocked()) {
                System.out.printf("%s get write lock\n", Thread.currentThread().getName());
            }
            Thread.sleep(500);
            map.put(key, value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public Set<String> getKeys() {
        reentrantReadWriteLock.readLock().lock();
        try {
            return map.keySet();
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }
}

public class ReentrantReadWriteLockInfo {

    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        MapReadWrite mapReadWrite = new MapReadWrite(readWriteLock);

        Runnable writer = () -> {
            for (int i = 0; i < 20; i++) {
                mapReadWrite.add(String.valueOf(i),String.valueOf(i));
            }  
        };

        Runnable reader = () -> {
          if (readWriteLock.isWriteLocked()) {
              System.out.println(Thread.currentThread().getName() + ": " + "got the lock");
          }
          readWriteLock.readLock().lock();
          System.out.println("Finally i got the damn lock");
          try {
              System.out.println("Thread.currentThread().getName() = " +
                      Thread.currentThread().getName() + ": " + mapReadWrite.getKeys());
          } finally {
               readWriteLock.readLock().unlock();
          }
        };

        Thread firstWriter = new Thread(writer, "First Writer Thread");
        Thread firstReader = new Thread(reader, "First Reader Thread");
        Thread secondReader = new Thread(reader, "Second Reader Thread");
        firstWriter.start();
        firstReader.start();
        secondReader.start();
    }
}
