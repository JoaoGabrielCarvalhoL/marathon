package br.com.joaogabriel.collections.list;

import br.com.joaogabriel.collections.model.Anime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSortingAnimeComparator implements Comparator<Anime> {
    @Override
    public int compare(Anime o1, Anime o2) {
        return o1.getId().compareTo(o2.getId());
    }

    public static void main(String[] args) {
        List<Anime> animes = new ArrayList<>(List.of(
                new Anime(101L, "Naruto", "Action"),
                new Anime(61L, "Digimon", "Action"),
                new Anime(177L, "Yu-Gi-Oh", "Action"),
                new Anime(1L, "Cavaleiros do Zodíaco", "Action"),
                new Anime(2L, "Dragon Ball Z", "Action")
        ));

        Collections.sort(animes, new ListSortingAnimeComparator());
        System.out.println("Sorting");
        animes.forEach(System.out::println);
    }
}
