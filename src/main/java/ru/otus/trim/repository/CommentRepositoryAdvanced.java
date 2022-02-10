package ru.otus.trim.repository;

import org.springframework.data.mongodb.repository.Query;
import ru.otus.trim.model.Comment;

import java.util.List;

public interface CommentRepositoryAdvanced {
    //@Query("{'book.id':'?0'}")
    List<Comment> findByBook(long id);
}
