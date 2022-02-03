package ru.otus.trim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.trim.model.Comment;
import ru.otus.trim.model.Genre;

public interface CommentRepository extends MongoRepository<Comment, Long> {

    //List<Genre> findAll();
}
