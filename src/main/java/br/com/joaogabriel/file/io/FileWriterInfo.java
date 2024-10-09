package br.com.joaogabriel.file.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * Writing
 * */
public class FileWriterInfo {
    /**
     * Write method overwrites whatever is in the file.
     * To append value, it's necessary to pass true in the constructor parameter.
     * */
    public static void main(String[] args) {
        File file = new File("files/test.txt");
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write("'I am the one who knocks.', Walter White\n");
            fileWriter.write("'I am not in danger, Skyler. I am the danger.', Walter White\n");
            fileWriter.write("'Say my name.', Walter White\n");
            fileWriter.write("\n");
            fileWriter.flush();
            /**
             * fileWriter.flush():
             *      Ensures that all content in the operating system buffer that is the content you want to write to the file is written before the file is closed,
             *     thus ensuring that the file is fully written.
             * */
        } catch (IOException exception) {
            throw new RuntimeException();
        }

    }
}
