package ru.otus.trim.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.trim.model.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAll();
}
