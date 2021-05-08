package htw.berlin.WebtechProjekt.Services;

import htw.berlin.WebtechProjekt.Models.Status;
import htw.berlin.WebtechProjekt.Models.ToDoListEntity;
import htw.berlin.WebtechProjekt.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListService {

    @Autowired
    private ToDoRepository ToDoRepo;

    public List<ToDoListEntity> findAll() {
        List<ToDoListEntity> ToDos = ToDoRepo.findAll();
        return ToDos;
    }

    public void addToDo(String task, Status status) {
        ToDoListEntity newToDo = new ToDoListEntity(task, status);
        ToDoRepo.save(newToDo);
    }


}
