package ru.otus.trim.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.otus.trim.model.Book;
import ru.otus.trim.model.Comment;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, Long>, CommentRepositoryAdvanced {
    List<Comment> findByBook(Book book); // it works
}
