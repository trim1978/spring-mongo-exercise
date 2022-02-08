package ru.otus.trim.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.otus.trim.model.Comment;
import ru.otus.trim.repository.CommentRepository;
import ru.otus.trim.service.SequenceGeneratorService;

@Component
public class CommentCascadeSaveEventsListener extends AbstractMongoEventListener<Comment> {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Comment> event) {
        //System.out.println(" BEFORE " + event);
        if (event.getSource().getId() < 1) {
            event.getSource().setTime(System.currentTimeMillis());
            event.getSource().setId(sequenceGeneratorService.generateLongSequence(Comment.SEQUENCE_NAME));
        }
        super.onBeforeConvert(event);
//        Book book = event.getSource();
//        if (book.getComments() != null) {
//            book.getComments().stream().filter(e -> Objects.isNull(e.getTime())).forEach(commentRepository::save);
//        }
    }
}
