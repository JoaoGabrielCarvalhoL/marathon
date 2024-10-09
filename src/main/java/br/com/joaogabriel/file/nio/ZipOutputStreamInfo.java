package br.com.joaogabriel.file.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamInfo {
    public static void main(String[] args) throws IOException {
        Path zipFile = Paths.get("folder/files.zip");
        Path filesToZip = Paths.get("folder/subfolder");
        zip(zipFile, filesToZip);

    }

    private static void zip(Path zip, Path toZip) {
        try (ZipOutputStream zipStream = new ZipOutputStream(Files.newOutputStream(zip));
             DirectoryStream<Path> directoryStream = Files.newDirectoryStream(toZip)) {
                for(Path file : directoryStream) {
                    System.out.println(file.getFileName());
                    ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                    zipStream.putNextEntry(zipEntry);
                    Files.copy(file, zipStream);
                    zipStream.closeEntry();
                }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
