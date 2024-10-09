package br.com.joaogabriel.file.io;

import java.io.File;
import java.io.IOException;

public class FileDirectoryInfo {
    public static void main(String[] args) throws IOException {
        File directory = new File("dir");
        boolean isCreated = directory.mkdir();
        if(isCreated) {
            System.out.println("done!");
        }
        File file = new File(directory, "new.txt");
        boolean newFile = file.createNewFile();
        if (newFile) {
            System.out.println("done!");
        }

        File renamed = new File(directory, "renamed.txt");
        boolean b = file.renameTo(renamed);
        if(b) System.out.println("Renamed!");
    }
}
