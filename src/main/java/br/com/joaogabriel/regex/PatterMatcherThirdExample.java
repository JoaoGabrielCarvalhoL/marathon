package br.com.joaogabriel.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * \d: all digits (numeric)
 * \D: Everything that is not a digit
 * \s: All whitespaces
 * \S: Everything that is not a whitespaces
 * \w: a-zA-Z (All digits and _)
 * \W: Everything that is a not defined in \w
 * []: (Range of characters)
 * ?: Zero or one
 * *: Zero or more
 * +: One or more
 * {n,m}: n at m
 * (): group
 * |: or
 * $: end of line
 * .: Interval .Ex.: 1.3: 123, 113, 143, n...
 * */
public class PatterMatcherThirdExample {
    public static void main(String[] args) {
        String regex = "[aAbc]"; //Search for a or b or c
        String text = "a1s2d3f4g5 h6j76k8l9 z0x1c2v3b_ 4n5m62q2w_ AAWEPQO@!!@!";

        String regexHex = "0[xX]([0-9a-fA-F])+(\\s|$)";
        String hexadecimal = "12 0x 0X 0xFFABC 0x10G 0x1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        Pattern patternHex = Pattern.compile(regexHex);
        Matcher matcherHex = patternHex.matcher(hexadecimal);

        while(matcher.find()) {
            System.out.println("Indexes: " + matcher.start() + " - Value: " + matcher.group());
        }

        System.out.println();
        System.out.println("Regex: " + regexHex);
        System.out.println("Find a valid hexadecimal number in: " + hexadecimal);

        while(matcherHex.find()) {
            System.out.println("At: " + matcherHex.start() + ": " + matcherHex.group());
        }

    }
}
