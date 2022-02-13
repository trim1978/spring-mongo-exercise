package ru.otus.trim.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.otus.trim.model.Author;
import ru.otus.trim.model.Book;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, Long>, BookRepositoryAdvanced {
    List<Book> findByAuthor(Author name); // it works
    List<Book> findByGenres(String genre); // ! работает
}
