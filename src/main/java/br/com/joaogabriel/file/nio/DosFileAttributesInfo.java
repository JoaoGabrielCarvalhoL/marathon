package br.com.joaogabriel.file.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;


public class DosFileAttributesInfo {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("nio/hiddenFile.txt");
        if (Files.notExists(path)) {
            Files.createFile(path);
            Files.setAttribute(path, "dos:hidden", true);
            Files.setAttribute(path, "dos:readonly", true);
        }

        DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println(dosFileAttributes.isHidden());
        System.out.println(dosFileAttributes.isReadOnly());

        /**
         * To change values always <name>View.class</name>
         * */

        DosFileAttributeView dosFileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);
        System.out.println(dosFileAttributeView.name());

    }
}
