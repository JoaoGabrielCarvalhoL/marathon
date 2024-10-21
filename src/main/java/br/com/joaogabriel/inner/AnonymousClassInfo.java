package br.com.joaogabriel.inner;

import br.com.joaogabriel.generics.model.Boat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Classes that will be used for a brief moment and cannot be reused in other places and times.
 * */

class Animal {
    public void walk() {
        System.out.println(".......................");
    }
}

public class AnonymousClassInfo {
    public static void main(String[] args) {
        Animal animal = new Animal() {
            @Override
            public void walk() {
                System.out.println("Walking in the shadows...");
            }
        };
        animal.walk();

        /**
         * Another example with interface
         * */

        List<Boat> boatList = new ArrayList<>(List.of(new Boat("First Boat"),new Boat("Second Boat"), new Boat("Third Boat")));
        boatList.sort(new Comparator<Boat>() {
            @Override
            public int compare(Boat o1, Boat o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        boatList.forEach(System.out::println);
    }
}
