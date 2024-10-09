package br.com.joaogabriel.file.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Path (interface) -> substitute to class File.
 * Paths -> concrete class to create a Path.
 *
 *
 * https://docs.oracle.com/javase/tutorial/essential/io/legacy.html
 * */

public class PathInfo {
    public static void main(String[] args) throws IOException {
        Path directory = Paths.get("directory-nio");
        if (Files.notExists(directory)) {
            Path directories = Files.createDirectories(directory);

            Path fileNio = Paths.get(directories.toString(), "file-nio.txt");
            Files.createFile(fileNio);
            System.out.println(fileNio.getFileName() + " " + fileNio.getParent().getFileName());
        }


    }
}
