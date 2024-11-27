package br.com.joaogabriel.streams.parallel;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreamInfo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        long number = 1_000_000_000L;
        sum(number);
        sumStreamIterate(number);
        sumParallelStream(number);
    }

    static void sum(long number) {
        System.out.println("Sum");
        long result = 0;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < number; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        long milliseconds = end - begin;
        System.out.println("Milliseconds: " + milliseconds);
        System.out.println("Sum: " + result);
    }

    static void sumStreamIterate(long number) {
        System.out.println("Sum with Stream Iterate");
        long begin = System.currentTimeMillis();
        Long result = Stream.iterate(1L, n -> n + 1).limit(number).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        long milliseconds = end - begin;
        System.out.println("Milliseconds: " + milliseconds);
        System.out.println("Sum: " + result);
    }

    static void sumParallelStream(long number) {
        System.out.println("Sum Parallel Stream");
        long begin = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1, number).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        long milliseconds = end - begin;
        System.out.println("Milliseconds: " + milliseconds);
        System.out.println("Sum: " + result);
    }
}
