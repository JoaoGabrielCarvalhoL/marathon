package br.com.joaogabriel.serialization;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SerializationInfo {

    private static final Logger logger = Logger.getLogger(SerializationInfo.class.getName());

    public static void main(String[] args) {
        Student student = new Student(UUID.randomUUID(), "João Gabriel", "joao@email.com", "somepassword");
        serialize(student);
        deserialize();

    }

    private static void serialize(Student student) {
        Path path = Paths.get("files/student.serializable");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            objectOutputStream.writeObject(student);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void deserialize() {
        Path path = Paths.get("files/student.serializable");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
            Student student = (Student) objectInputStream.readObject();
            System.out.println(student);
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class Student implements Serializable {

    private UUID id;
    private String name;
    private String email;
    /**
     * The keyword transient ignores a field when an object is a serializable.
     * The field doesn't be serializable
     * */
    private transient String password;

    public Student() {
    }

    public Student(UUID id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}