package ru.otus.trim.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
public class Comment {
    @Id // Позволяет указать какое поле является идентификатором
    private long id;
    private String text;

    public Comment(String text) {
        this.text = text;
    }

    public Comment() {
    }

    public Comment(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
