package ru.otus.trim.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.otus.trim.model.Book;
import ru.otus.trim.repository.CommentRepository;
import ru.otus.trim.service.SequenceGeneratorService;

import java.util.Objects;

@Component
public class BookCascadeSaveEventsListener extends AbstractMongoEventListener<Book> {
    //@Autowired
    private CommentRepository commentRepository;
    //@Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Book> event) {
        System.out.println(" BEFORE " + event);
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGeneratorService.generateLongSequence(Book.SEQUENCE_NAME));
        }
        super.onBeforeConvert(event);
        Book book = event.getSource();
        if (book.getComments() != null) {
            book.getComments().stream().filter(e -> Objects.isNull(e.getTime())).forEach(commentRepository::save);
        }
    }
}
