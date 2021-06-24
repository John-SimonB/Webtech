package htw.berlin.WebtechProjekt.Services;

import htw.berlin.WebtechProjekt.Models.ToDoListEntity;
import htw.berlin.WebtechProjekt.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoListService {

    @Autowired
    private ToDoRepository ToDoRepo;

    public List<ToDoListEntity> findAll(String toDoUser) {

        var iterator = ToDoRepo.findAll();
        var todos = new ArrayList<ToDoListEntity>();
        for(ToDoListEntity t : iterator) {
            if(t.getOwner()!=null && t.getOwner().equals(toDoUser)) todos.add(t);

        }
        return todos;
    }

    public void addToDo(String task, /*Boolean state, */LocalDate date, String owner) {
        ToDoListEntity newToDo = new ToDoListEntity(task, /*state, */date, owner);
        ToDoRepo.save(newToDo);
    }

    /*
    public boolean deleteToDo(Long id) {
        ToDoRepo.deleteById(id);
        if(ToDoRepo.findAll().equals(ToDoRepo.getOne(id))) {
            return false;
        }
        return true;
    }
    */
    public void deleteToDo(Long id) {
        ToDoRepo.deleteById(id);
    }

    public void deleteAll(){
        ToDoRepo.deleteAll();
    }

    public ToDoListEntity save(ToDoListEntity toDoListEntity) {
        ToDoRepo.save(toDoListEntity);
        return toDoListEntity;
    }
}
