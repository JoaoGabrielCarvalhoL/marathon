package br.com.joaogabriel.collections.model;

import java.util.Objects;

public class Anime implements Comparable<Anime> {
    private Long id;
    private String name;
    private String category;

    public Anime() {}

    public Anime(Long id, String name, String category) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
        Objects.requireNonNull(category);
        this.id = id;
        this.name = name;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Anime anime = (Anime) o;
        return Objects.equals(id, anime.id) && Objects.equals(name, anime.name) && Objects.equals(category, anime.category);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(category);
        return result;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public int compareTo(Anime o) {
        /**
         * negative: this.id < o.id
         * positive: this.id > o.id
         * equal: this.id == o.id
         * */

        if (this.id.equals(o.id))
            return 0;
        else if (this.id > o.id){
            return 1;
        } else {
            return -1;
        }
    }
}
