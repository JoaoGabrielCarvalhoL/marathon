package br.com.joaogabriel.collections.map;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapInfo {
    public static void main(String[] args) {
        //Ordering by key
        NavigableMap<String,String> navigableMap = new TreeMap<>();
        navigableMap.put("A", "Letter A");
        navigableMap.put("B", "Letter B");
        navigableMap.put("C", "Letter C");
        navigableMap.put("D", "Letter D");
        navigableMap.put("E", "Letter E");
        navigableMap.put("F", "Letter F");


        for (Map.Entry<String, String> entry : navigableMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
