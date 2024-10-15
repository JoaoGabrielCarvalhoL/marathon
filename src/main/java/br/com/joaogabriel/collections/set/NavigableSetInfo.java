package br.com.joaogabriel.collections.set;

import br.com.joaogabriel.collections.model.Smartphone;

import java.util.*;

class SmartphoneComparator implements Comparator<Smartphone> {

    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getSerial().compareTo(o2.getSerial());
    }
}

public class NavigableSetInfo {
    public static void main(String[] args) {
        NavigableSet<Smartphone> smartphoneTreeSet = new TreeSet<>(new SmartphoneComparator());
        Smartphone model = new Smartphone(UUID.randomUUID().toString(), "model");
        Smartphone another = new Smartphone(UUID.randomUUID().toString(), "another");
        smartphoneTreeSet.add(model); //Must be implement Comparable
        smartphoneTreeSet.add(another);
        smartphoneTreeSet.forEach(System.out::println);

        /**
         * TreeSet use comparator ou comparable to verify a duplicate element.
         * In this case, it's best to keep equals and compare consistent.
         * */
    }
}
