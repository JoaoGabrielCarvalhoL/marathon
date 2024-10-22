package br.com.joaogabriel.lambda.function;

/**
 * @param <T> Type of the input
 * @param <R> Type of the output result
 * */
@FunctionalInterface
public interface Function<T, R> {

    R apply(T t);
}
