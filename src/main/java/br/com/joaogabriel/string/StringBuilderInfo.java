package br.com.joaogabriel.string;

public class StringBuilderInfo {

    public static void main(String[] args) {
        /**
         * Strings are not immutable, because StringBuilder is not a String but a class that works with Strings.
         * It becomes a String from the moment it is transformed.
         * */
        StringBuilder stringBuilder = new StringBuilder(); //By default, the empty constructor has capacity to 16 characters to allocate. The value is doubled always necessary.
        stringBuilder.append("João Gabriel Carvalho");
    }
}
