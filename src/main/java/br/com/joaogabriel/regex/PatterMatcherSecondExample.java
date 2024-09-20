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
 *
 *
 *
 * */
public class PatterMatcherSecondExample {
    public static void main(String[] args) {
        String regex = "\\d";
        String secondRegex = "\\D";
        String thirdRegex = "\\s";
        String fourthRegex = "\\S";
        String fifthRegex = "\\w";
        String sixthRegex = "\\W";
        String text = "a1s2d3f4g5 h6j76k8l9 z0x1c2v3b_ 4n5m62q2w_ AAWEPQO@!!@!";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        Pattern secondPatter = Pattern.compile(secondRegex);
        Matcher secondMatcher = secondPatter.matcher(text);

        Pattern thirdPatter = Pattern.compile(thirdRegex);
        Matcher thirdMatcher = thirdPatter.matcher(text);

        Pattern fourthPatter = Pattern.compile(fourthRegex);
        Matcher fourthMatcher = fourthPatter.matcher(text);

        Pattern fifthPatter = Pattern.compile(fifthRegex);
        Matcher fifthMatcher = fifthPatter.matcher(text);

        Pattern sixthPatter = Pattern.compile(sixthRegex);
        Matcher sixthMatcher = sixthPatter.matcher(text);


        while(matcher.find()) {
            System.out.println("Indexes: " + matcher.start() + " - Value: " + matcher.group());
        }

        System.out.println("Within numbers");
        while(secondMatcher.find()) {
            System.out.println("Indexes: " + secondMatcher.start() + " - Value: " + secondMatcher.group());
        }

        System.out.println("Whitespaces");
        while(thirdMatcher.find()) {
            System.out.println("Indexes: " + thirdMatcher.start() + " - Value: " + thirdMatcher.group());
        }

        System.out.println("Without Whitespaces");
        while(fourthMatcher.find()) {
            System.out.println("Indexes: " + fourthMatcher.start() + " - Value: " + fourthMatcher.group());
        }

        System.out.println("\\w");
        while(fifthMatcher.find()) {
            System.out.println("Indexes: " + fifthMatcher.start() + " - Value: " + fifthMatcher.group());
        }

        System.out.println("\\W");
        while(sixthMatcher.find()) {
            System.out.println("Indexes: " + sixthMatcher.start() + " - Value: " + sixthMatcher.group());
        }
    }
}
