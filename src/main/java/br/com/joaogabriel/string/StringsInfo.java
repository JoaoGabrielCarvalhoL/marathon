package br.com.joaogabriel.string;

public class StringsInfo {

    /**
     * Strings on Java are immutable.
     * */

    String name = "João Gabriel"; //String constant pool
    String secondName = "João Gabriel";
    /**
     * Heap {
     *     Pool String {}
     * }
     * */

    public static void main(String[] args) {
        StringsInfo example = new StringsInfo();

        /**
         * The variables point to the same spare memory address in the heap.
         * */
        System.out.println(example.name == example.secondName); //Check address not value.

        example.name.concat("Carvalho");
        System.out.println(example.name);

        System.out.println(example.name == example.secondName); //After concat, the result still equals, because concat return another string

        /**
         *  When we retrieve the address this new string result of concat, now the result is false.
         *  Because example.name point the new address memory, address result of concat
         *
         *  On the heap pool:
         *  [João Gabriel] -> appointed by name and anotherName
         *  [Carvalho] -> no references
         *  [João GabrielCarvalho] -> no references
         *
         *  When:
         *  example.name = example.name.concat("Carvalho");
         *  [João GabrielCarvalho] -> now appointed by name
         *
         *  Now the verification of memory address is false:
         *  example.name appointed to [João GabrielCarvalho] != example.anotherName appointed to [João Gabriel]
         *
         *  */

        String value = new String("Value"); /** 1. Reference Variable | 2. Object String \ 3. New string on pool with not exists. */
        String v = "Value";
        System.out.println(value == v);
        /**
         * When we use the constructor of class String, the new string is allocated in heap,
         *  being encapsulated by the string object and its value being referenced in the heap.
         * Heap [
         *  "Value" -> appointed by value
         *      pool of strings [
         *          "Value" -> appointed by v
         *      ]
         * ]
         * */

        /**
         * Returns a canonical representation for the string object.
         * Comparison between values on pool
         * */
        System.out.println(v == value.intern());
    }
}
