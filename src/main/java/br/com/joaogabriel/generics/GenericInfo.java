package br.com.joaogabriel.generics;

import br.com.joaogabriel.collections.model.Anime;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/***/

public class GenericInfo {
    public static void main(String[] args) {
        //Type erasure.
        List<String> values = new ArrayList<>();
        values.add("João");

        values.forEach(System.out::println);

        Random random = new Random(System.currentTimeMillis());
        Long index = random.nextLong();

        add(values, new Anime(index, "Yu-Gi-Oh", "Cards"));
        //At here, working well.

        values.forEach(System.out::println); //Now exception.
    }

    private static void add (List list, Anime anime) {
        list.add(anime);
    }
}
