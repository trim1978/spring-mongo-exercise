package ru.otus.trim.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comment {
    //@Id // Позволяет указать какое поле является идентификатором
    private long time;
    private String text;

    public Comment(String text) {
        this.time = System.currentTimeMillis();
        this.text = text;
    }

    public Comment() {
    }

    public Comment(long time, String text) {
        this.time = time;
        this.text = text;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
