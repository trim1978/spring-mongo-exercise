package ru.otus.trim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import ru.otus.trim.model.Author;
import ru.otus.trim.model.Genre;

import java.util.List;

public interface GenreRepository extends MongoRepository<Genre, Integer> {

    //List<Genre> findAll();
}
