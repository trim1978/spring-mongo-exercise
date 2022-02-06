package ru.otus.trim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.trim.model.Comment;
import ru.otus.trim.repository.AuthorRepository;
import ru.otus.trim.repository.BookRepository;
import ru.otus.trim.repository.GenreRepository;
import ru.otus.trim.model.Author;
import ru.otus.trim.model.Book;
import ru.otus.trim.model.Genre;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    //@Autowired
    public BookRepository books;
    //@Autowired
    public AuthorRepository authors;
    //@Autowired
    public GenreRepository genres;

//    @Transactional
//    @Override
//    public Book setBook(Book book) {
//        Genre genre = book.getGenre();
//        int genreId = genre.getId();
////        if (genreId == 0) {
////            genre = getGenre(genre.getName());
////        }
//        if (book.getId() == 0){
//            Author author = book.getAuthor();
//            if (author.getId() == 0){
//                author = authors.insertAuthor(author.getName());
//            }
//            return books.insertBook(book.getTitle(), author.getId(), genreId);
//        }
//        else{
//            books.updateBookById(book.getId(), genreId);
//        }
//        return book;
//    }

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

    @Transactional(readOnly = true)
    @Override
    public Genre getGenre(String name) {
        return genres.findAll().stream().filter(t -> t.getName().equalsIgnoreCase(name)).findAny().orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> getAuthors() {
        return authors.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Genre> getGenres() {
        return genres.findAll();
    }



    @Override
    public List<Comment> getCommentsByBookId(long bookID) {
        Book book = books.findById(bookID).get();
        if (book != null) return book.getComments();
        return new LinkedList<Comment> ();
    }

    @Override
    public void addCommentToBookById(long bookID, String text) {
        Book book = books.findById(bookID).get();
        if (book != null) {
            book.addComment(text);
            books.save(book);
        }

    }
}
