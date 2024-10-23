package br.com.joaogabriel.lambda.method.reference;

import br.com.joaogabriel.lambda.function.Function;
import br.com.joaogabriel.lambda.method.reference.model.Anime;
import br.com.joaogabriel.lambda.method.reference.service.AnimeComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

/**
 * When the lambda use a unique method, can be used method reference instead
 *
 * There are four kinds of method references:
 * 1. Reference to a static method:
 *      ContainingClass::staticMethodName
 *
 * 2. Reference to an instance method of a particular object
 *      containingObject::instanceMethodName
 *
 * 3. Reference to an instance method of an arbitrary object of a particular type
 *      ContainingType::methodName
 *
 * 4. Reference to a constructor
 *      ClassName::new
 * */
public class MethodReferenceInfo {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Naruto", 10), new Anime("Digimon", 22),
                new Anime("DBZ", 100), new Anime("Yu-Gi-Oh", 2)));

        List<Anime> copyAnimeList = new ArrayList<>(List.of(new Anime("Naruto", 10), new Anime("Digimon", 22),
                new Anime("DBZ", 100), new Anime("Yu-Gi-Oh", 2)));
        Collections.sort(animeList, (anime1, anime2) -> anime1.getTitle().compareTo(anime2.getTitle()));
        Collections.sort(copyAnimeList, AnimeComparators::compareByTitle);
        System.out.println(animeList);
        System.out.println(copyAnimeList);


        List<String> names = new ArrayList<>(List.of("Rimuru", "Veldora", "Hikimuru"));
        names.sort(String::compareTo);
        System.out.println(names);

        Function<String, Integer> convertStringToIntegerNumbers = Integer::parseInt;
        Integer apply = convertStringToIntegerNumbers.apply("100");
        System.out.println(apply);

        BiPredicate<List<String>, String> verify = List::contains;
        System.out.println(verify.test(names, "Veldora"));

        //When to use?
        Supplier<AnimeComparators> comparatorsSupplier = AnimeComparators::new;
        AnimeComparators animeComparators = comparatorsSupplier.get();

        BiFunction<String, Integer, Anime> animeBiFunction = Anime::new;
        Anime superChampions = animeBiFunction.apply("Supercampeões", 100);
        System.out.println(superChampions);
    }
}
