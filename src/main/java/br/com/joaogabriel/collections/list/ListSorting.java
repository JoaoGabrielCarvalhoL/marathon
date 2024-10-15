package br.com.joaogabriel.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSorting {
    public static void main(String[] args) {
        List<String> values = new ArrayList<>(
                List.of("Naruto", "Digimon", "Yu-Gi-Oh", "Cavaleiros do Zodíaco", "Dragon Ball Z"));
        Collections.sort(values);
        values.forEach(System.out::println);
    }
}
