package ru.otus.trim.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.otus.trim.model.Comment;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, Long> {

    @Query("{'book.id':'?0'}")
    List<Comment> findByBook(long id);
}
