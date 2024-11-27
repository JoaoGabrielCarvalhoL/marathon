package br.com.joaogabriel.streams;


import br.com.joaogabriel.streams.model.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Data processing
 * */
public class StreamsInfoImperative {

    /**
     * Order LightNovel by title
     * Retrieve the first three light novels with price less than 4
     * */

    private static List<LightNovel> lightNovelList = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no life", 2.99),
            new LightNovel("Fullmetal Achemist", 5.99),
            new LightNovel("Kumo Desuga", 1.99),
            new LightNovel("Monogatari", 4.00)));

    public static void main(String[] args) {
        List<LightNovel> imperative = imperative();
        imperative.forEach(System.out::println);
    }

    private static List<LightNovel> imperative() {
        lightNovelList.sort((Comparator.comparing(LightNovel::getTitle)));
        List<LightNovel> filtered = new ArrayList<>();
        for (LightNovel lightNovel : lightNovelList) {
            if (lightNovel.getPrice() < 4) {
                filtered.add(lightNovel);
            }
        }
        if (filtered.size() > 3) {
            List<LightNovel> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                list.add(filtered.get(i));
            }
            return list;
        }
        return filtered;
    }


}
