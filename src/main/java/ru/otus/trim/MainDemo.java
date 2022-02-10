package ru.otus.trim;

//import com.github.cloudyrock.spring.v5.EnableMongock;
import io.mongock.runner.springboot.EnableMongock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ru.otus.trim.model.Author;
import ru.otus.trim.model.Book;
import ru.otus.trim.repository.AuthorRepository;
import ru.otus.trim.repository.BookRepository;
import ru.otus.trim.service.LibraryService;

@EnableMongock
@SpringBootApplication
@EnableMongoRepositories
public class MainDemo {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    //@Autowired
    //private AuthorRepository repository;

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(MainDemo.class);
//        BookRepository bookRepository = context.getBean(BookRepository.class);
//        AuthorRepository authors = context.getBean(AuthorRepository.class);
//        LibraryService library = context.getBean(LibraryService.class);

//        Author dost = new Author(5, "Dostoevsky");
//        dost = authors.save(dost);
//        Book idiot = new Book("Idiot", dost, "drama");
//        library.setBook(idiot);
//
//        System.out.println(idiot);
//
//        library.addCommentToBookById(idiot.getId(), "Wow");

        //System.out.println(library.getBooksByGenre("drama"));

    /*
        Thread.sleep(3000);

        System.out.println("\n\n\n----------------------------------------------\n\n");
        System.out.println("Авторы в БД:");
        repository.findAll().forEach(p -> System.out.println(p.getName()));
        System.out.println("\n\n----------------------------------------------\n\n\n");
        *
     */
        //library.addCommentToBookById(1, "Greate");

    }
}
