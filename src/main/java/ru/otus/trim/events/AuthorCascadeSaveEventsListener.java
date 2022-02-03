package ru.otus.trim.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import ru.otus.trim.model.Author;
import ru.otus.trim.repository.AuthorRepository;
import ru.otus.trim.service.DatabaseSequence;
import ru.otus.trim.service.SequenceGeneratorService;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Component
public class AuthorCascadeSaveEventsListener extends AbstractMongoEventListener<Author> {
    @Autowired
    private AuthorRepository knowledgeRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Author> event) {
        //System.out.println(" BEFORE " + event);
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGeneratorService.generateSequence(Author.SEQUENCE_NAME));
        }
        super.onBeforeConvert(event);
        Author student = event.getSource();
//        if (student.getExperience() != null) {
//            student.getExperience().stream().filter(e -> Objects.isNull(e.getId())).forEach(knowledgeRepository::save);
//        }
    }
}
