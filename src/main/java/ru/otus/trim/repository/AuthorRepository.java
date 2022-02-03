package ru.otus.trim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import ru.otus.trim.model.Author;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, Integer> {

    //List<Author> findAll();
}
