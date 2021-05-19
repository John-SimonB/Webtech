package htw.berlin.WebtechProjekt.Services;

import htw.berlin.WebtechProjekt.Models.Status;
import htw.berlin.WebtechProjekt.Models.ToDoListEntity;
import htw.berlin.WebtechProjekt.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ToDoListService {

    @Autowired
    private ToDoRepository ToDoRepo;

    public List<ToDoListEntity> findAll() {
        List<ToDoListEntity> ToDos = ToDoRepo.findAll();
        return ToDos;
    }

    public void addToDo(String task, Status state, LocalDate date) {
        ToDoListEntity newToDo = new ToDoListEntity(task, state, date);
        ToDoRepo.save(newToDo);
    }

    public void deleteToDo(String id) {
        Long ToDoId = Long.parseLong(id);
        ToDoRepo.deleteById(ToDoId);
    }

    public void deleteAll(){
        ToDoRepo.deleteAll();
    }

    public void save(ToDoListEntity toDoListEntity) {
        ToDoRepo.save(toDoListEntity);
    }
}
