package br.com.joaogabriel.file.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Basic attributes associated with a file in a file system.
 * Basic file attributes are attributes that are common to many file systems and consist of mandatory and optional file attributes as defined by this interface.
 * */

public class BasicFileAttributesInfo {
    public static void main(String[] args) throws IOException {

        /**
         * BasicFileAttributes
         *      - DosFileAttributes (Windows)
         *      - PosixFileAttributes (Unix)
         * */

        LocalDateTime date = LocalDateTime.now().minusDays(10);
        File file = new File("nio/newfile.txt");
        boolean isCreated = file.createNewFile();
        if (isCreated) {
            boolean isChanged = file.setLastModified(date.toInstant(ZoneOffset.UTC).toEpochMilli());
            System.out.println(isChanged);
        }
        file.delete();

        //Nio

        Path pathFile = Paths.get("nio/newfilenio.txt");
        Files.createFile(pathFile);
        byte[] bytes = Files.readAllBytes(pathFile);

        FileTime fileTime = FileTime.from(date.toInstant(ZoneOffset.UTC));
        Files.setLastModifiedTime(pathFile, fileTime);
        System.out.println(Files.isWritable(pathFile));
        System.out.println(Files.isReadable(pathFile));
        System.out.println(Files.isExecutable(pathFile));

        Path path = Paths.get("nio/newfilenio.txt");
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
        FileTime creationTime = basicFileAttributes.creationTime();
        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime();
        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();
        System.out.println(creationTime);
        System.out.println(lastModifiedTime);
        System.out.println(lastAccessTime);
        //Files.delete(Paths.get("nio/newfilenio.txt"));

        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        fileAttributeView.setTimes(lastModifiedTime, FileTime.fromMillis(System.currentTimeMillis()), creationTime);

        Files.delete(pathFile);

    }
}
