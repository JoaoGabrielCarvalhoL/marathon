package br.com.joaogabriel.file.io;

import java.io.*;

public class BufferedReadInfo {
    public static void main(String[] args) {
        File file = new File("files/text.txt");
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException exception) {
            throw new RuntimeException();
        }
    }
}
