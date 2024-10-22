package br.com.joaogabriel.lambda.consumer;

/**
 * Performs an operation and has no return.
 * */
@FunctionalInterface
public interface Consumer<T> {

    void accept(T t);
}
