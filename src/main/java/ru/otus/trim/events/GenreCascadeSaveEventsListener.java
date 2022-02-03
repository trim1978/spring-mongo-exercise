package ru.otus.trim.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.otus.trim.model.Genre;
import ru.otus.trim.repository.GenreRepository;
import ru.otus.trim.service.SequenceGeneratorService;

@Component
public class GenreCascadeSaveEventsListener extends AbstractMongoEventListener<Genre> {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Genre> event) {
        //System.out.println(" BEFORE " + event);
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGeneratorService.generateIntSequence(Genre.SEQUENCE_NAME));
        }
        super.onBeforeConvert(event);
    }
}
