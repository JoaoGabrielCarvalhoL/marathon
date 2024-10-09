package br.com.joaogabriel.file.io;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

/**
 * File: Create a file and some functionalities.
 * FileWriter: Writing
 * FileReader: Reading
 * BufferedReader: More performance to read a file with data on memory.
 * BufferedWriter: More performance to write a file with data on memory.
 * */
public class FileInfo {
    public static void main(String[] args) {
        File file = new File("files/first_file.txt");
        try {
            System.out.println("Creating a new file: " + file.getName());
            boolean isCreated = file.createNewFile();
            if (isCreated) {
                System.out.println(isCreated);
                System.out.println(file.getPath());
                System.out.println(file.getAbsolutePath());
                System.out.println(file.isDirectory());
                System.out.println(file.isFile());
                System.out.println(file.isHidden());
                System.out.println(file.canExecute());
                System.out.println(file.canRead());
                System.out.println(file.canWrite());
                System.out.println(new Date(file.lastModified()));
                System.out.println(
                        Instant.ofEpochMilli(file.lastModified())
                                .atZone(ZoneId.systemDefault()).toLocalDateTime());

                boolean isExists = file.exists();
                if (isExists) {
                    file.delete();
                }
                System.out.println("Deleting the file: " + file.getName());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
