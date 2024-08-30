package br.com.joaogabriel.poo.interfacee;

public interface Interfacee {

    public abstract void someMessage();
    //By default, methods in an interface are public and abstract.

    default void hello() {
        System.out.println("hello.");
    }

    //Static methods will never be overridden.
    static void some() {
        System.out.println("Max memory: " + Runtime.getRuntime().maxMemory());
        System.out.println("Total memory: " + Runtime.getRuntime().totalMemory());
    }

}
