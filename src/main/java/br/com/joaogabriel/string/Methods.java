package br.com.joaogabriel.string;

public class Methods {
    public static void main(String[] args) {
        String name = "Walter White";
        String assistant;
        String numbers = "123456789";

        //charAt: Returns the char value at the specified index
        System.out.println(name.charAt(name.length() -1));
        System.out.println(name.charAt(0));

        //length: Returns the length of this string
        //be careful on length and index.
        // length: Start with 1.
        // index: start with 0
        System.out.println(name.length());

        //replace: Replaces each substring of this string that matches the literal target sequence with the specified literal replacement sequence
        assistant = name.replace("W", "w");
        System.out.println(assistant);

        //substring(): Returns a string that is a substring of this string. The substring begins at the specified beginIndex and extends to the character at index endIndex - 1.
        //Be careful on beginning and end index.
        String substring = numbers.substring(0, 5); //12345
        System.out.println(substring);

        String substring1 = numbers.substring(4);//5,6,7,8,9
        System.out.println(substring1);

        //trim(): Returns a string whose value is this string, with all leading and trailing space removed
        String trim = assistant.trim();
        System.out.println(trim);


    }
}
