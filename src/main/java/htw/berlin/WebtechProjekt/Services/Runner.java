package htw.berlin.WebtechProjekt.Services;

import htw.berlin.WebtechProjekt.Models.ToDoListEntity;
import htw.berlin.WebtechProjekt.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static htw.berlin.WebtechProjekt.Models.Status.offen;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private ToDoRepository toDorepository;

    @Override
    public void run(String... args) throws Exception {
        ToDoListEntity firstTask = new ToDoListEntity("Staubsaugen", offen);
        toDorepository.save(firstTask);
    }
}
