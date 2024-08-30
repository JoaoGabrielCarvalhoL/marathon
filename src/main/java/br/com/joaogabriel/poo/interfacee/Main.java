package br.com.joaogabriel.poo.interfacee;

public class Main {
    public static void main(String[] args) {
        ConcreteClass concreteClass = new ConcreteClass();
        concreteClass.someMessage();
        concreteClass.hello();
        Interfacee.some();
    }
}
