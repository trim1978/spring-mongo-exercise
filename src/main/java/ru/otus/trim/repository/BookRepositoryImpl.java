package ru.otus.trim.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ru.otus.trim.model.Book;

import java.util.List;

public class BookRepositoryImpl implements BookRepositoryAdvanced{

    @Autowired
    private MongoOperations mongo;

    @Override
    public List<Book> findByGenre(String genre) {
        return mongo.find(Query.query(Criteria.where ("genres").elemMatch(Criteria.byExample(genre))), Book.class);
    }
}
