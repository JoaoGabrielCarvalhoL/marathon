package br.com.joaogabriel.streams.finding.matching;

import br.com.joaogabriel.streams.model.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindingMatchingInfo {
    private static List<LightNovel> lightNovelList = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo Desuga", 1.99),
            new LightNovel("Monogatari", 4.00)));
    public static void main(String[] args) {
        boolean b = lightNovelList.stream().anyMatch(element -> element.getPrice() > 5);
        boolean b1 = lightNovelList.stream().allMatch(element -> element.getPrice() > 0);
        boolean b2 = lightNovelList.stream().noneMatch(element -> element.getPrice() > 0);
        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);

        Optional<LightNovel> fullmetalAlchemist =
                lightNovelList.stream().filter(element -> element.getTitle().equals("Fullmetal Alchemist")).findFirst();

        fullmetalAlchemist.ifPresent(System.out::println);
        Optional<LightNovel> any = lightNovelList.stream().filter(element -> element.getPrice() > 0).findAny();
        any.ifPresent(System.out::println);
    }
}
