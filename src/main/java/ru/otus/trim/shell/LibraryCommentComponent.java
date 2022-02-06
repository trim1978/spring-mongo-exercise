package ru.otus.trim.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.trim.model.Author;
import ru.otus.trim.model.Book;
import ru.otus.trim.model.Comment;
import ru.otus.trim.model.Genre;
import ru.otus.trim.service.LibraryService;

import java.util.List;

@ShellComponent
public class LibraryCommentComponent {
    @Autowired
    private LibraryService library;

    @ShellMethod(value = "Get comments", key = {"get_comments", "gc"})
    public List<Comment> getComments(long id) {
        return library.getCommentsByBookId(id);
    }

    @ShellMethod(value = "Add comment", key = {"add_comment", "ac"})
    //@ShellOption()
    public void addComment(long id, String comment) {
        ;
    }

}
