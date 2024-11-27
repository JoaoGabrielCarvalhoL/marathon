package br.com.joaogabriel.streams.reduce;

import br.com.joaogabriel.streams.model.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Reduce: Operator final
 * Given a collection of elements, get a unique value.
 * */
public class ReduceInfo {

    private static List<LightNovel> lightNovelList = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no life", 2.99),
            new LightNovel("Fullmetal Achemist", 5.99),
            new LightNovel("Kumo Desuga", 1.99),
            new LightNovel("Monogatari", 4.00)));

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Optional<Integer> reduce = integers.stream().reduce(Integer::sum);
        reduce.ifPresent(System.out::println);

        System.out.println(integers.stream().reduce(0, (x, y) -> x + y));

        System.out.println(integers.stream().reduce(1, (x, y) -> x * y));

        integers.stream().reduce((x, y) -> x > y ? x : y).ifPresent(System.out::println);
        integers.stream().reduce(Integer::max).ifPresent(System.out::println);

        lightNovelList.stream().map(LightNovel::getPrice)
                .filter(price -> price > 3)
                .reduce(Double::sum)
                .ifPresent(System.out::println);
    }
}
