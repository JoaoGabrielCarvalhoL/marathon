package br.com.joaogabriel.file.nio;


import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Get all files from a directory
 * */
public class DirectoryStreamInfo {
    public static void main(String[] args) {
        Path marathon = Paths.get(".");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(marathon)) {
            /**
             * Not recursive
             * Only parent folders not the children
             * */
            for (Path path : stream) {
                System.out.println(path.getFileName());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
