package br.com.joaogabriel.optional;

import br.com.joaogabriel.collections.model.Anime;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Try to avoid NullPointerException
 * The return of method can be empty instead null
 * Optional.of() values non-null
 * Optional.ofNullable() values can be null
 * */
public class OptionalInfo {
    public static void main(String[] args) {

        List<Anime> animes = new ArrayList<>(List.of(
                new Anime(101L, "Naruto", "Action"),
                new Anime(61L, "Digimon", "Action"),
                new Anime(177L, "Yu-Gi-Oh", "Action"),
                new Anime(1L, "Cavaleiros do Zodíaco", "Action"),
                new Anime(2L, "Dragon Ball Z", "Action")));

        Optional<Anime> anime = find(animes, new Anime(101L, "Naruto", "Action"));
        System.out.println(anime.isPresent());

        Optional<Anime> another = find(animes, new Anime(101L, "Wolverine", "Action"));
        Anime anime1 = another.orElse(new Anime());
        another.ifPresent(System.out::println);

        another.ifPresentOrElse(a -> System.out.println(a), () -> {
            new Anime();
        });




    }

    public static <T> Optional<T> find(List<T> collection, T object) {
        return collection.stream()
                .filter(object::equals)
                .findFirst()
                .map(Optional::of)
                .orElseThrow(RuntimeException::new);
    }

}
