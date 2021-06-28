package htw.berlin.WebtechProjekt.Models;

import htw.berlin.WebtechProjekt.Services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private ToDoListService toDoListService;

    @Override
    public void run(String... args) throws Exception {
        //toDoListService.addToDo("Saugen", LocalDate.now(), "john@gmail.com");
        //toDoListService.addToDo("Waschen", LocalDate.now());
        //toDoListService.addToDo("Putzen", LocalDate.now());
    }
}
