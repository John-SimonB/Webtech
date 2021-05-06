package htw.berlin.WebtechProjekt.services;

import htw.berlin.WebtechProjekt.Models.ToDoList;
import htw.berlin.WebtechProjekt.services.ToDoListService;

import java.util.UUID;

public class ToDoListImpl implements ToDoListService {


    @Override
    public ToDoList returnlist() {
        String id = UUID.randomUUID().toString();
        String task = createTask();
        Boolean status = false;
        return new ToDoList(id, task, status);
    }

    private String createTask(){
        return "";
    }
}
