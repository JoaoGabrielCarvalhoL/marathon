package br.com.joaogabriel.collections.map;

import br.com.joaogabriel.collections.model.Anime;
import br.com.joaogabriel.collections.model.Consumer;

import java.util.HashMap;
import java.util.Map;

public class MapHashMapInfo {
    public static void main(String[] args) {
        Consumer firstConsumer = new Consumer("João Gabriel");
        Consumer secondConsumer = new Consumer("Test consumer");

        Anime first = new Anime(101L, "Naruto", "Action");
        Anime second = new Anime(61L, "Digimon", "Action");

        Map<Consumer, Anime> consumerAnimeMap = new HashMap<>();
        consumerAnimeMap.put(firstConsumer, first);
        consumerAnimeMap.put(secondConsumer, second);
        for (Map.Entry<Consumer, Anime> entry : consumerAnimeMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
