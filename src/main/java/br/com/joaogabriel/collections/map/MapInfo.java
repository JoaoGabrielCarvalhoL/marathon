package br.com.joaogabriel.collections.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map is not a collection.
 * */
public class MapInfo {
    public static void main(String[] args) {
        /**
         * Always a class have Map on name, the ordination is give by hash when an element is added in a collection.
         * */

        /**
         * Duplicated key is not allowed. The value is replaced if key exists.
         * The keys is a set collection.
         * The values is a collection.
         * */
        Map<String, String> map = new HashMap<>();
        map.put("name", "João Gabriel Carvalho");
        map.put("email", "27.joaogabriel@gmail.com");

        Set<String> keys = map.keySet();
        Collection<String> values = map.values();

        keys.forEach(System.out::println);
        values.forEach(System.out::println);

        System.out.println(map.get("email"));

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.print("Key: " + entry.getKey() + " Value: " + entry.getValue() + "\n");
        }
    }
}
