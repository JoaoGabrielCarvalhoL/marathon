package br.com.joaogabriel.streams.generating.stream;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * IntStream, DoubleStream, LongStream higher performance instead of wrapper class.
 * Avoid boxing and unboxing
 * */
public class GeneratingStreamInfo {
    public static void main(String[] args) {
        IntStream.range(1, 50).filter(number -> number % 2 == 0)
                .forEach(System.out::println);

        IntStream.rangeClosed(1, 50).filter(number -> number % 2 == 0)
                .forEach(System.out::println);

        Stream<String> name = Stream.of("João", "Gabriel", "Carvalho", "Lopes", "Cruz");
        name.map(String::toUpperCase)
                .forEach(System.out::println);

        int[] numbers = {1,2,3,4,5,6,7,8,9};
        IntStream stream = Arrays.stream(numbers);
        OptionalInt max = stream.max();
        System.out.println(max);
    }
}
