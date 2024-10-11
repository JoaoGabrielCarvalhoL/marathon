package br.com.joaogabriel.collections;

import br.com.joaogabriel.collections.model.Smartphone;

import java.util.UUID;

/**
 *
 * */
public class EqualsInfo {
    public static void main(String[] args) {
        String name = "João Gabriel";
        String copyName = "João Gabriel";

        String copyOfCopy = new String("João Gabriel");
        System.out.println(name == copyName);
        System.out.println(copyOfCopy == copyName);
        System.out.println(copyOfCopy.equals(copyName));

        String uuid = UUID.randomUUID().toString();
        Smartphone some = new Smartphone(uuid, "Some");
        Smartphone copyOfSome = new Smartphone(uuid, "Some");

        System.out.println(some.equals(copyOfSome)); //False, because is compare a memory address;
        System.out.println(some.equals(some));
    }
}
