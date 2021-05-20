package htw.berlin.WebtechProjekt.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static htw.berlin.WebtechProjekt.Models.Status.offen;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private ToDoListService toDoListService;

    @Override
    public void run(String... args) throws Exception {
        //toDoListService.deleteAll();
        //toDoListService.addToDo("Waschen", offen, LocalDate.now());
        //toDoListService.addToDo("Putzen", offen, LocalDate.now());
    }
}
