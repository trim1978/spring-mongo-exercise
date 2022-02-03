package ru.otus.trim.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.otus.trim.model.Author;
import ru.otus.trim.repository.AuthorRepository;

@Component
public class AuthorCascadeSaveEventsListener extends AbstractMongoEventListener<Author> {
    @Autowired
    private AuthorRepository knowledgeRepository;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Author> event) {
        System.out.println(" BEFORE " + event);
        super.onBeforeConvert(event);
        Author student = event.getSource();
//        if (student.getExperience() != null) {
//            student.getExperience().stream().filter(e -> Objects.isNull(e.getId())).forEach(knowledgeRepository::save);
//        }
    }
}