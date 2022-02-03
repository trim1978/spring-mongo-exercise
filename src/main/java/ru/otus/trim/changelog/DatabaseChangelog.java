package ru.otus.trim.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import ru.otus.trim.model.Author;
import ru.otus.trim.model.Book;
import ru.otus.trim.model.Comment;
import ru.otus.trim.model.Genre;
import ru.otus.trim.repository.AuthorRepository;
import ru.otus.trim.repository.BookRepository;
import ru.otus.trim.repository.GenreRepository;

@ChangeLog
public class DatabaseChangelog {
    private Author a1, a2, a3;

    private Genre g1, g2, g3;

    @ChangeSet(order = "001", id = "dropDb", author = "stvort", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "initAuthors", author = "admin", runAlways = true)
    public void initAuthors(AuthorRepository repository){
        a1 = repository.save(new Author("Pushkin"));
        a2 = repository.save(new Author("Lermontov"));
        a3 = repository.save(new Author("Nosov"));
    }

    @ChangeSet(order = "003", id = "initGenres", author = "admin", runAlways = true)
    public void initGenres(GenreRepository repository){
        g1 = repository.save(new Genre("drama"));
        g2 = repository.save(new Genre("comedy"));
        g3 = repository.save(new Genre("thriller"));
    }

    @ChangeSet(order = "004", id = "initBooks", author = "admin", runAlways = true)
    public void initBooks(BookRepository repository){
        Book b1 = repository.save(new Book("Metel", a1, g1));
        Book b2 = repository.save(new Book("Fantazery", a3, g2));
//        Book b3 = new Book("Borodino", a2, g1);
//        b3.addComment("Wonderfull !");
//        repository.save(b3);
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
