package br.com.joaogabriel.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Wildcard: ?
 * */

abstract class Animal {
    public abstract void consultation();
}

class Dog extends Animal {

    @Override
    public void consultation() {
        System.out.println("Dog");
    }
}

class Cat extends Animal {
    @Override
    public void consultation() {
        System.out.println("Cat");
    }
}

public class WildcardInfo {
    public static void main(String[] args) {
        Dog[] dogs = new Dog[] { new Dog(), new Dog() };
        Cat[] cats = new Cat[] { new Cat(), new Cat() };

        System.out.println("Arrays");
        printArrays(dogs);
        printArrays(cats);

        System.out.println("List");
        List<Animal> dogsList = new ArrayList<>(List.of(new Dog(), new Dog()));
        List<Animal> catsList = new ArrayList<>(List.of(new Cat(), new Cat()));

        /**
         * List<Dog> dogsList = new ArrayList<>(List.of(new Dog(), new Dog()));
         * printList(dogsList) //Compilation error.
         * */

        printList(dogsList);
        printList(catsList);
        printWildcardList(dogsList);
        printWildcardListSuper(catsList);
    }

    private static void printArrays(Animal[] animals) {
        Arrays.stream(animals).forEach(Animal::consultation);
    }

    private static void printList(List<Animal> animals) {
        animals.forEach(Animal::consultation);
    }

    /**
     * List only to read.
     * Cannot add new elements on the list.
     * */
    private static void printWildcardList(List<? extends Animal> animals) {
        animals.forEach(Animal::consultation);
    }

    /**
     * Super
     * Only parent of Animal. In this case, only Object.
     * */
    private static void printWildcardListSuper(List<? super Animal> animals) {
        if (animals instanceof Animal) {
            List<Animal> list = animals.stream().map(Animal.class::cast).toList();
            list.forEach(System.out::println);
        }
    }
}
