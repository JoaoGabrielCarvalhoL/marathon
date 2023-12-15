package br.com.joaogabriel.basic.primitive.types;
public class PrimitiveTypes {
    /* int, double, float, char, byte, long and boolean.*/
    /**
     * Data Type            Size                     Range values                               Default value
     * byte                 1 byte                      -128 to 127                             0
     * short                2 byte                      -32768 to 32767                         0
     * int                  4 bytes                     -2,147,483,648 to 2,147,483,647         0
     * long                 8 bytes  -9,223,372,036,854,775,808 to 9,223,372,036,854,750,000    0
     * float                4 bytes                     -3.4e-038 to 3.4e+038                   0.0f
     * double               8 bytes                     1.7e-308 to 1.7e+308                    0.0d
     * boolean              1 byte                      true or false                           false
     * char                 1 byte                                                              \u0000
     */

    /**
     * Local scope variables need to be initialized.*/
    public static void main(String[] args) {

        int firstNumber = 15;
        double secondNumber = 14.0789654145156;
        float thirdNumber = 13.42F;
        char character = 'J';
        char ascii = 99;
        char unicode = '\u0041';
        byte fourthNumber = -128;
        long bigNumber = 123456789L;
        short smallNumber = 1;
        boolean is = true;

        System.out.printf("First Number: %d\n", firstNumber);
        System.out.printf("Second Number: %f\n", secondNumber);
        System.out.printf("Third Number: %f\n", thirdNumber);
        System.out.printf("Character Number: %c\n", character);
        System.out.printf("Character Number: %c\n", ascii);
        System.out.printf("Character Number: %c\n", unicode);
        System.out.printf("Fourth Number: %d\n", fourthNumber);
        System.out.printf("Big Number: %d\n", bigNumber);
        System.out.printf("Small Number: %d\n", smallNumber);
        System.out.printf("Is: %b\n", is);

    }
}
