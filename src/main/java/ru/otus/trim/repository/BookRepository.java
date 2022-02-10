package ru.otus.trim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.otus.trim.model.Book;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, Long>, BookRepositoryAdvanced {

    @Query("{'author.$id':?0}")
    List<Book> findBooksByAuthor(long id);
}
