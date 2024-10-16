package br.com.joaogabriel.collections.model;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Consumer {
    private Long id;
    private String name;

    public Consumer() {}

    public Consumer(String name) {
        this.id = ThreadLocalRandom.current().nextLong(0, 1000000000);
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Consumer consumer = (Consumer) o;
        return Objects.equals(id, consumer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
