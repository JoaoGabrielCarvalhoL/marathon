package br.com.joaogabriel.collections.list;

import br.com.joaogabriel.collections.model.Smartphone;

import java.util.*;

/**
 * In declaration, always interface, be list, or set etc. And must be Object/Wrapper of primitive types. And the implementation, what you need.
 * */
public class ListInfo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(); //dynamic size
        names.add("João Gabriel");
        names.add("Carvalho");

        List<String> copy = new ArrayList<>(names);
        names.remove(1);
        names.remove("João Gabriel");
        copy.forEach(System.out::println);

        String id = UUID.randomUUID().toString();
        Smartphone first = new Smartphone(id, "first");
        Smartphone second = new Smartphone(UUID.randomUUID().toString(), "second");
        Smartphone third = new Smartphone(UUID.randomUUID().toString(), "third");
        Smartphone fourth = new Smartphone(UUID.randomUUID().toString(), "fourth");
        Smartphone fifty = new Smartphone(UUID.randomUUID().toString(), "fifty");

        List<Smartphone> smartphoneList = new ArrayList<>(List.of(first, second, third, fourth, fifty));

        smartphoneList.forEach(System.out::println);
        System.out.println(smartphoneList.contains(new Smartphone(id, "first")));



    }
}

