package ru.otus.trim.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "authors")
public class Author {
    @Id
    private int id;
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public Author() {
    }

    public Author(int id, String name) {
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
