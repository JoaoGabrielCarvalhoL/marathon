package br.com.joaogabriel.streams.collectors;

import br.com.joaogabriel.streams.model.Category;
import br.com.joaogabriel.streams.model.LightNovel;
import br.com.joaogabriel.streams.model.Promotion;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsInfo {
    private static List<LightNovel> lightNovelList = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99, Category.FANTASY),
            new LightNovel("Overlord", 3.99, Category.FANTASY),
            new LightNovel("Violet Evergarden", 5.99, Category.DRAMA),
            new LightNovel("No Game no life", 2.99, Category.FANTASY),
            new LightNovel("Fullmetal Alchemist", 5.99, Category.FANTASY),
            new LightNovel("Kumo Desuga", 1.99, Category.FANTASY),
            new LightNovel("Monogatari", 4.00, Category.ROMANCE)));

    public static void main(String[] args) {
        System.out.println(lightNovelList.size());
        System.out.println(lightNovelList.stream().count());
        System.out.println(lightNovelList.stream().collect(Collectors.counting()));

        lightNovelList.stream().max(Comparator.comparing(LightNovel::getPrice))
                .ifPresent(System.out::println);

        lightNovelList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)))
                .ifPresent(System.out::println);

        System.out.println(lightNovelList.stream()
                .mapToDouble(LightNovel::getPrice)
                .sum());

        System.out.println(lightNovelList.stream()
                .collect(Collectors.summingDouble(LightNovel::getPrice)));

        lightNovelList.stream().mapToDouble(LightNovel::getPrice).average().ifPresentOrElse(System.out::println,
                () -> System.out.println("Something wrong..."));

        System.out.println(lightNovelList.stream()
                .collect(Collectors.averagingDouble(LightNovel::getPrice)));

        DoubleSummaryStatistics collect = lightNovelList.stream().collect(Collectors.summarizingDouble(LightNovel::getPrice));
        System.out.println(collect);

        System.out.println(lightNovelList.stream().map(LightNovel::getTitle).collect(Collectors.joining(", ")));

        /**
         * GROUPING FIRST WAY
         * */
        List<LightNovel> fantasy = new ArrayList<>();
        List<LightNovel> romance = new ArrayList<>();
        List<LightNovel> drama = new ArrayList<>();

        for (LightNovel lightNovel : lightNovelList) {
            switch (lightNovel.getCategory()) {
                case DRAMA -> drama.add(lightNovel);
                case FANTASY -> fantasy.add(lightNovel);
                case ROMANCE -> romance.add(lightNovel);
            }
        }
        Map<Category, List<LightNovel>> categoryListMap = new HashMap<>();
        categoryListMap.put(Category.FANTASY, fantasy);
        categoryListMap.put(Category.ROMANCE, romance);
        categoryListMap.put(Category.DRAMA, drama);

        /**
         * Second way*/
        Map<Category, List<LightNovel>> collect1 = lightNovelList.stream().collect(Collectors.groupingBy(LightNovel::getCategory));

        /**
         * Another groupingBy
         * */

        Map<Promotion, List<LightNovel>> collect2 = lightNovelList.stream()
                .collect(Collectors.groupingBy(element -> element.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE));

        System.out.println(collect2);

        Map<Category, Map<Promotion, List<LightNovel>>> collect3 = lightNovelList
                .stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.groupingBy(element -> element.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE)));

        System.out.println(collect3);

        Map<Category, Long> collect4 = lightNovelList.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.counting()));
        System.out.println(collect4);

        Map<Category, Optional<LightNovel>> collect5 = lightNovelList
                .stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.maxBy(Comparator.comparing(LightNovel::getPrice))));
        System.out.println(collect5);

        Map<Category, LightNovel> collect6 = lightNovelList.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)), Optional::get)));
        System.out.println(collect6);

        Map<Category, DoubleSummaryStatistics> collect7 = lightNovelList.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.summarizingDouble(LightNovel::getPrice)));
        System.out.println(collect7);

        Map<Category, LinkedHashSet<Promotion>> collect8 = lightNovelList.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.mapping(pr -> pr.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE, Collectors.toCollection(LinkedHashSet::new))));
        System.out.println(collect8);

    }
}
