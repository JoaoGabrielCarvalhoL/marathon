package br.com.joaogabriel.streams;


import br.com.joaogabriel.streams.model.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Data processing
 * */
public class StreamsInfo {

    /**
     * Order LightNovel by title
     * Retrieve the first three light novels with price less than 4
     * */

    private static List<LightNovel> lightNovelList = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no life", 2.99),
            new LightNovel("Fullmental Achemist", 5.99),
            new LightNovel("Kumo Desuga", 1.99),
            new LightNovel("Monogatari", 4.00)));

    public static void main(String[] args) {
        /**
         * Operations in streams:
         * Finals or intermediary
         *
         * Intermediary: returns a stream, which can be chained together
         * */
        Stream<LightNovel> stream = lightNovelList.stream(); //sequence of elements

        List<LightNovel> stream1 = stream();
        stream1.forEach(System.out::println);

    }

    private static List<LightNovel> stream() {
        return lightNovelList.stream().sorted((Comparator.comparing(LightNovel::getTitle)))
                .filter(element -> element.getPrice() < 4)
                .limit(3)
                .toList();
    }


}
