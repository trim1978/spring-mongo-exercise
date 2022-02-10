package ru.otus.trim.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ru.otus.trim.model.Author;
import ru.otus.trim.model.Book;

import java.util.List;

public class BookRepositoryImpl implements BookRepositoryAdvanced{

    private final MongoOperations mongo;

    public BookRepositoryImpl(MongoOperations mongo) {
        this.mongo = mongo;
    }

    @Override
    public List<Book> findByGenre(String genre) {
        //db.books.find({ genres: { $elemMatch: { $eq: "drama" } } })
        return mongo.find(Query.query(Criteria.where ("genres").elemMatch(new Criteria().is(genre))), Book.class);
    }
    @Override
    public List<Book> findByAuthor(String author) {
        //Author a = new Author(author);
        return mongo.find (Query.query(Criteria.where ("author").elemMatch(Criteria.where ("name").is(author))), Book.class);
    }
}
