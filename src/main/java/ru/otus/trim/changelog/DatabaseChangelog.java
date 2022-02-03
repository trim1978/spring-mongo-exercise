package ru.otus.trim.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import ru.otus.trim.model.Author;
import ru.otus.trim.model.Genre;
import ru.otus.trim.repository.AuthorRepository;
import ru.otus.trim.repository.GenreRepository;

@ChangeLog
public class DatabaseChangelog {
    private Author a1;
    private Author a2;
    private Author a3;

    private Genre g1;
    private Genre g2;
    private Genre g3;

    @ChangeSet(order = "001", id = "dropDb", author = "stvort", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "initAuthors", author = "admin", runAlways = true)
    public void initAuthorledges(AuthorRepository repository){
        a1 = repository.save(new Author("Pushkin"));
        a2 = repository.save(new Author("Lermontov"));
        a3 = repository.save(new Author("Nosov"));
    }

    @ChangeSet(order = "003", id = "initGenres", author = "admin", runAlways = true)
    public void initGenredges(GenreRepository repository){
        g1 = repository.save(new Genre("drama"));
        g2 = repository.save(new Genre("comedy"));
        g3 = repository.save(new Genre("thriller"));
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
