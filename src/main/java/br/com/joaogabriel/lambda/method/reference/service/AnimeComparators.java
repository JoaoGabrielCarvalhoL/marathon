package br.com.joaogabriel.lambda.method.reference.service;

import br.com.joaogabriel.lambda.method.reference.model.Anime;

public class AnimeComparators {

    public static int compareByTitle(Anime anime1, Anime anime2) {
        return anime1.getTitle().compareTo(anime2.getTitle());
    }
}
