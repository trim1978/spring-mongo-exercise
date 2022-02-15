package ru.otus.trim.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.trim.model.Book;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Test Books CRUD")
@ComponentScan(basePackages = "ru.otus.trim")
@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
@Import(LibraryServiceImpl.class)
class BookCRUDTests {

    private static final String AUTHOR_PUSHKIN = "Pushkin";
    private static final String GENRE_DRAMA = "drama";
    private static final String TITLE_1 = "Metel";
    @Autowired
    private LibraryService library;

    @DisplayName("insert")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    void insertTest() {
        Book book = new Book (TITLE_1, AUTHOR_PUSHKIN, GENRE_DRAMA);
        library.setBook(book);
        assertThat(book.getTitle()).isEqualTo(TITLE_1);
        assertThat(book.getAuthor().getName()).isEqualTo(AUTHOR_PUSHKIN);
        assertThat(book.getGenres().contains(GENRE_DRAMA));
        assertThat(library.getBookById(book.getId())).isEqualTo(book);
    }

    @DisplayName("update")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    void updateTest() {
        Book book = new Book (TITLE_1, AUTHOR_PUSHKIN, GENRE_DRAMA);
        library.setBook(book);
        book.getGenres().add ("lyrics");
        library.setBook(book);
        assertThat(library.getBookById(book.getId()).getGenres().contains("lyric"));
    }

    @DisplayName("delete")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    void deleteTest() {
        Book book = new Book (TITLE_1, AUTHOR_PUSHKIN, GENRE_DRAMA);
        library.setBook(book);
        library.removeBookById(book.getId());
        assertThat(library.getBookById(book.getId())).isNull();
    }

    @DisplayName("select")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    void selectTest() {
        Book book = new Book (TITLE_1, AUTHOR_PUSHKIN, GENRE_DRAMA);
        library.setBook(book);
        assertThat(library.getBooks()).isNotEmpty();
    }
}
