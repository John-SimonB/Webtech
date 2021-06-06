package htw.berlin.WebtechProjekt.Services;

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
        //toDoListService.addToDo("Saugen", false, LocalDate.now());
        //toDoListService.addToDo("Waschen", offen, LocalDate.now());
        //toDoListService.addToDo("Putzen", offen, LocalDate.now());
    }
}
