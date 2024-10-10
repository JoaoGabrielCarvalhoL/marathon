package br.com.joaogabriel.serialization;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SerializableInfo {

    private static final Logger logger = Logger.getLogger(SerializationInfo.class.getName());

    public static void main(String[] args) {
        User student = new User(UUID.randomUUID(), "João Gabriel", "joao@email.com");
        SerializableInfo serializableInfo = new SerializableInfo();

        try {
            serializableInfo.saveInAFile("first_file", student);
        } catch (IOException exception) {
            logger.log(Level.SEVERE, "Deu ruim família. Olha o porquê dessa bomba aí: ");
            logger.log(Level.SEVERE, exception.getMessage());
        }

    }

    private void saveInAFile(String filename, User student) throws IOException {
        logger.log(Level.INFO, "Verifying if folder Students exists.");
        Path path = Paths.get("students");
        if (Files.notExists(path)) {
            logger.log(Level.INFO, "Creating folder Students");
            Files.createDirectories(path);
        }
        String nameFolder = student.getId().toString();
        Path folderStudent = Paths.get(path.toString(), nameFolder);
        if (Files.notExists(folderStudent)) {
            logger.log(Level.INFO, "Creating folder to user id: {0}", nameFolder);
            Files.createDirectories(folderStudent);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm");
        String format = LocalDateTime.now().format(formatter);
        String finalFilename = filename + format + ".txt";
        Path file = Paths.get(folderStudent.toString(), finalFilename);
        Files.createFile(file);

        logger.log(Level.INFO, "Writing data on file: {0}", file.getFileName());
        try (FileWriter fileWriter = new FileWriter(file.toFile(), true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(student.getId().toString());
            bufferedWriter.write(";");
            bufferedWriter.write(student.getName());
            bufferedWriter.write(";");
            bufferedWriter.write(student.getEmail());
            bufferedWriter.write(";");
            bufferedWriter.newLine();
            bufferedWriter.flush();

        } catch (IOException exception) {
            throw new RuntimeException();
        }
    }
}

class User {
    private UUID id;
    private String name;
    private String email;

    public User() {
    }

    public User(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}