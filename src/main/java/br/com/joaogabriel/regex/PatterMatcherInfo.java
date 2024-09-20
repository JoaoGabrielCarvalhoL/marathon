package br.com.joaogabriel.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Notation for representing patterns in strings
 * Pattern and Matcher
 * */

public class PatterMatcherInfo {
    public static void main(String[] args) {
        //Simple example, finding {a} on name
        String name = "Joao Gabriel Carvalho Lopes da Cruz";
        String regex = "a";
        System.out.println(name);
        System.out.println("Length: " + name.length());
        System.out.println("Incidence of: " + regex);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        List<Integer> indexes = new ArrayList<>();
        System.out.println("Finding at indexes: ");
        while(matcher.find()) {
            System.out.print(matcher.start() + " ");
            indexes.add(matcher.start());
        }
        System.out.println();
        for(Integer index : indexes) {
            System.out.println("Index: " + index + " - Letter: " + name.charAt(index));
        }

    }
}
