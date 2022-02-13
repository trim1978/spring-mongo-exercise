package ru.otus.trim.repository;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import ru.otus.trim.model.Book;
import ru.otus.trim.model.Comment;
import ru.otus.trim.utils.RawResultPrinter;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.ObjectOperators.valueOf;

public class CommentRepositoryImpl implements CommentRepositoryAdvanced{
    private final MongoTemplate mongoTemplate;
    private final RawResultPrinter rawResultPrinter;

    public CommentRepositoryImpl(MongoTemplate mongoTemplate, RawResultPrinter rawResultPrinter) {
        this.mongoTemplate = mongoTemplate;
        this.rawResultPrinter = rawResultPrinter;
    }

//    @Override
//    public List<Comment> findByBook(long id) {
//        System.out.println("FIND " + id + " " );
//        return List.of();
////        Aggregation aggregation = newAggregation(
////                match(Criteria.where("id").is(id))
////                , unwind("book")
////                , project().andExclude("_id").and(valueOf("book").as("experience_map")
////                , project().and("experience_map").arrayElementAt(1).as("experience_id_map")
////                , project().and("experience_id_map.v").as("experience_id")
////                , lookup("knowledge", "experience_id", "_id", "experience")
////                , project().and("experience._id").as("_id").and("experience.name").as("name")
////        );
//
//        //Document rawResults = mongoTemplate.aggregate(aggregation, Comment.class, Book.class).getRawResults();
//        //rawResultPrinter.prettyPrintRawResult(rawResults);
//        //return mongoTemplate.aggregate(aggregation, Comment.class, Book.class).getMappedResults();
//    }
}
