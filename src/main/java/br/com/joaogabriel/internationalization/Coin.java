package br.com.joaogabriel.internationalization;

import java.text.NumberFormat;
import java.util.Locale;

public class Coin {
    public static void main(String[] args) {
        Locale localeUk = Locale.UK;
        Locale localeCanada = Locale.CANADA;
        Locale localeGermany = Locale.GERMANY;

        NumberFormat[] numberFormatArray = new NumberFormat[4];
        numberFormatArray[0] = NumberFormat.getCurrencyInstance();
        numberFormatArray[1] = NumberFormat.getCurrencyInstance(localeUk);
        numberFormatArray[2] = NumberFormat.getCurrencyInstance(localeCanada);
        numberFormatArray[3] = NumberFormat.getCurrencyInstance(localeGermany);

        Double value = 10_123.7867d;

        for (NumberFormat numberFormat : numberFormatArray) {
            numberFormat.setMaximumFractionDigits(2);
            System.out.println(numberFormat.getCurrency() + ": " + numberFormat.format(value));

        }
    }
}
