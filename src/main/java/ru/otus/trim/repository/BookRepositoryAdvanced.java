package ru.otus.trim.repository;

import ru.otus.trim.model.Book;

import java.util.List;

public interface BookRepositoryAdvanced {
    List<Book> findByGenre(String genre);
}
