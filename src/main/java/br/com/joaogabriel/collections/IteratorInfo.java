package br.com.joaogabriel.collections;

import br.com.joaogabriel.collections.model.Anime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorInfo {
    public static void main(String[] args) {
        List<Anime> animes = new ArrayList<>(List.of(
                new Anime(101L, "Naruto", "Action"),
                new Anime(61L, "Digimon", "Adventure"),
                new Anime(177L, "Yu-Gi-Oh", "Cards"),
                new Anime(1L, "Cavaleiros do Zodíaco", "Action"),
                new Anime(2L, "Dragon Ball Z", "Action")
        ));

        /**
         * ConcurrentModificationException
         for (Anime anime : animes) {
            if (anime.getCategory().equals("Action")) {
                animes.remove(anime);
            }
        }
         */

        /**
         *
         * In Java, an Iterator is an interface that provides a way to traverse a collection of objects sequentially.
         * It is part of the Java Collections Framework and can be used with various collection types like List, Set, Queue, and Map.
         * The primary purpose of an iterator is to allow the user to process every element of a collection without exposing the underlying structure.
         * */
        Iterator<Anime> iterator = animes.iterator();
        while (iterator.hasNext()) {
            Anime next = iterator.next();
            if (next.getCategory().equals("Action")) {
                iterator.remove();
            }
        }

        animes.forEach(System.out::println);
    }
}
