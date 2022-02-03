package ru.otus.trim.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import ru.otus.trim.model.Author;
import ru.otus.trim.repository.AuthorRepository;

@ChangeLog(order = "001")
public class DatabaseChangelog {
    private Author springDataKnowledge;
    private Author mongockKnowledge;
    private Author aggregationApiKnowledge;

    @ChangeSet(order = "001", id = "dropDb", author = "stvort", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "initAuthors", author = "admin", runAlways = true)
    public void initAuthorledges(AuthorRepository repository){
        springDataKnowledge = repository.save(new Author("Pushkin"));
        mongockKnowledge = repository.save(new Author("Lermontov"));
        aggregationApiKnowledge = repository.save(new Author("Nosov"));
    }

//    @ChangeSet(order = "002", id = "insertLermontov", author = "ydvorzhetskiy")
//    public void insertLermontov(MongoDatabase db) {
//        MongoCollection<Document> myCollection = db.getCollection("persons");
//        var doc = new Document().append("name", "Lermontov");
//        myCollection.insertOne(doc);
//    }
//
//    @ChangeSet(order = "003", id = "insertPushkin", author = "stvort")
//    public void insertPushkin(PersonRepository repository) {
//        repository.save(new Person("Pushkin"));
//    }
}
