package htw.berlin.WebtechProjekt.Services;

import htw.berlin.WebtechProjekt.Models.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static htw.berlin.WebtechProjekt.Models.Status.offen;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private ToDoListService toDoListService;

    @Override
    public void run(String... args) throws Exception {
        //toDoListService.deleteAll();
        //toDoListService.addToDo("Wischen", offen);
    }
}
