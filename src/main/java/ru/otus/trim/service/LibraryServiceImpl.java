package ru.otus.trim.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.trim.model.Comment;
import ru.otus.trim.repository.AuthorRepository;
import ru.otus.trim.repository.BookRepository;
import ru.otus.trim.repository.CommentRepository;
import ru.otus.trim.model.Author;
import ru.otus.trim.model.Book;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    public final BookRepository books;
    public final AuthorRepository authors;
    public final CommentRepository comments;

    public LibraryServiceImpl(BookRepository books, AuthorRepository authors, CommentRepository comments) {
        this.books = books;
        this.authors = authors;
        this.comments = comments;
    }

    @Transactional
    @Override
    public void setBook(Book book) {
        //Genre genre = book.getGenre();
        //int genreId = genre.getId();
//        if (genreId == 0) {
//            genre = getGenre(genre.getName());
//        }
        if (book.getId() == 0){
            Author author = book.getAuthor();
            if (author.getId() == 0){
                authors.save(author);
            }
            books.save(book);
        }
        else{
            //books.updateBookById(book.getId(), genreId);
        }
        //return book;
    }

    @Transactional
    @Override
    public Book removeBookById(long bookID) {
        Book book = books.findById(bookID).get();
        if (book != null) books.delete(book);
        return book;
    }

    @Transactional(readOnly = true)
    @Override
    public Book getBookById(long bookID) {
        return books.findById(bookID).get();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getBooks() {
        return books.findAll();
    }

    @Transactional
    @Override
    public Author getAuthor(String name) {
        return authors.findAll().stream().filter(t -> t.getName().equalsIgnoreCase(name)).findAny().orElse(authors.save(new Author(0, name)));
    }

    @Override
    public List<Book> getBooksByAuthorName(String name) {
        Author author = authors.findByName(name).get(0);
        return books.findBooksByAuthor(author.getId());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> getAuthors() {
        return authors.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> getGenres() {
        return new LinkedList<String>  ();
    }



    @Transactional(readOnly = true)
    @Override
    public List<Comment> getCommentsByBookId(long bookID) {
        //Book book = books.findById(bookID).get();
        //if (book != null) return book.getComments();
        //return comments.findAll();//ByBook(new ObjectId());
        //return comments.findByBook(new ObjectId());
        return comments.findByBook(bookID);
    }

    @Override
    public void addCommentToBookById(long bookID, String text) {
        Book book = books.findById(bookID).get();
        if (book != null) {
            comments.save(new Comment(book, text));
        }
        else System.out.println("book "+ bookID + " not found");
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        return books.findByGenre (genre);
    }
    @Override
    public List<Book> getBooksByAuthor(String author) {
        return books.findByAuthor (author);
    }
}
