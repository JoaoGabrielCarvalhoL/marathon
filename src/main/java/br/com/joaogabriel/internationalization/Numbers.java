package br.com.joaogabriel.internationalization;

import java.text.NumberFormat;
import java.util.Locale;

public class Numbers {
    public static void main(String[] args) {
        Locale localeUk = Locale.UK;
        Locale localeCanada = Locale.CANADA;
        Locale localeGermany = Locale.GERMANY;

        NumberFormat[] numberFormatArray = new NumberFormat[4];
        numberFormatArray[0] = NumberFormat.getInstance();
        numberFormatArray[1] = NumberFormat.getInstance(localeUk);
        numberFormatArray[2] = NumberFormat.getInstance(localeCanada);
        numberFormatArray[3] = NumberFormat.getInstance(localeGermany);

        Double value = 10_123.7867d;

        for (NumberFormat numberFormat : numberFormatArray) {
            System.out.println(numberFormat.format(value));
        }
    }
}
