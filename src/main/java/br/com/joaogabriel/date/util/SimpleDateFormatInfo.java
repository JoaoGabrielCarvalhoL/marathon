package br.com.joaogabriel.date.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatInfo {
    public static void main(String[] args) {
        String pattern = "dd/MM/yyyy G 'at' HH:mm:ss z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
