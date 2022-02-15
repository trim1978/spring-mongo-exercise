package ru.otus.trim.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.trim.model.Comment;
import ru.otus.trim.repository.AuthorRepository;
import ru.otus.trim.repository.BookRepository;
import ru.otus.trim.repository.CommentRepository;
import ru.otus.trim.model.Author;
import ru.otus.trim.model.Book;

import java.util.ArrayList;
import java.util.HashSet;
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
        if (book.getId() > 0) {
            Book book1 = books.findById(book.getId()).get();
            book1.setGenres(book.getGenres());
            authors.save(book.getAuthor());
            book1.setAuthor(book.getAuthor());
            book = book1;
        }
        books.save(book);
    }

    @Transactional
    @Override
    public Book removeBookById(long bookID) {
        Book book = books.findById(bookID).get();
        if (book != null) {
            books.delete(book);
            for (Comment c : comments.findByBook(book)) comments.delete(c);
        }
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
    public List<Book> getBooksByAuthor(String name) {
        Author author = authors.findByName(name);
        if (author != null) {
            return books.findByAuthor(author);
        }
        return List.of();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> getAuthors() {
        return authors.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> getGenres() {
        List<Book> booksAll = books.findAll();
        HashSet<String> genres = new HashSet<>();
        for (Book book : booksAll) {
            for (String genre : book.getGenres()){
                genres.add(genre);
            }
        }
        return new ArrayList<String>(genres);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getCommentsByBookId(long bookID) {
        Book book = books.findById(bookID).get();
        if (book != null) {
            return comments.findByBook(book);
        }
        return List.of();
    }

    @Transactional()
    @Override
    public void addCommentToBookById(long bookID, String text) {
        Book book = books.findById(bookID).get();
        if (book != null) {
            comments.save(new Comment(book, text));
        } else throw new RuntimeException("book " + bookID + " not found");
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getBooksByGenre(String genre) {
        return books.findByGenres(genre);
    }
}
