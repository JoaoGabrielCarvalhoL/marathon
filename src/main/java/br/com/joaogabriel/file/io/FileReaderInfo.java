package br.com.joaogabriel.file.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderInfo {
    public static void main(String[] args) {
        File file = new File("files/test.txt");
        try(FileReader fileReader = new FileReader(file)) {
            /**
             * fileReader.read(): return an asci unicod of character.
             * When it reaches the end of the file, it returns -1.
             * */
            int assistant;
            while ((assistant = fileReader.read()) != -1) {
                System.out.print((char) assistant);
            }
        }catch (IOException ioException) {
            throw new RuntimeException();
        }
    }
}
