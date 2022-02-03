package ru.otus.trim.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring.data.mongodb")
public class MongoProps {
    private int port;
    private String database;
    private String uri;

    public MongoProps() {
    }

    public MongoProps(int port, String database, String uri) {
        this.port = port;
        this.database = database;
        this.uri = uri;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
