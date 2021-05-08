package htw.berlin.WebtechProjekt.Controller;

import htw.berlin.WebtechProjekt.Models.Status;
import htw.berlin.WebtechProjekt.Models.ToDoListEntity;
import htw.berlin.WebtechProjekt.Repository.ToDoRepository;
import htw.berlin.WebtechProjekt.Services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ToDoRestController {

    @Autowired
    private ToDoListService toDoListService;


    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/ToDos")
    public List<ToDoListEntity> allToDos() {
        return toDoListService.findAll();
    }


}