package ru.otus.trim.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "genres")
public class Genre {
    @Id // Позволяет указать какое поле является идентификатором
    private int id;
    private String name;

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
