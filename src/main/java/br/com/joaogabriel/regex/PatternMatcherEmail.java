package br.com.joaogabriel.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//https://regexr.com/
public class PatternMatcherEmail {
    public static void main(String[] args) {
        String regex = "([a-zA-Z0-9._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
        String values =
                "luffy@hotmail.com, 123jotaro@gmail.com, #@!zoro@mail.br, teste@gmail.com, sakura@mail, naruto123, vegeta@email.com.br";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(values);

        while(matcher.find()) {
            System.out.println(matcher.start() + ": " + matcher.group());
        }
    }
}
