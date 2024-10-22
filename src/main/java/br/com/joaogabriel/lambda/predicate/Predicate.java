package br.com.joaogabriel.lambda.predicate;

/**
 * Lambda is an implementation of a functional interface.
 * A functional interface is an interface that has only one abstract method and returns a boolean.
 * */

@FunctionalInterface
public interface Predicate<T> {

    /**
     * Anonymous
     * Functions
     * Concise
     * */
    boolean test(T t);

    /**
     * Syntax:
     * (parameters...) -> (expression)
     *
     * */
}
