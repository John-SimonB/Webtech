package htw.berlin.WebtechProjekt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import htw.berlin.WebtechProjekt.Models.CustomUserDetails;
import htw.berlin.WebtechProjekt.Models.ToDoListEntity;
import htw.berlin.WebtechProjekt.Services.ToDoListService;

import java.util.List;

@RestController
public class ToDoRestController {


    @Autowired
    public ToDoListService toDoListService;


    @GetMapping(path = "/rest/todos")
    public ResponseEntity<List<ToDoListEntity>> allToDos(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails toDoUser = (CustomUserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(toDoListService.findAll(toDoUser.getUsername()));
    }

    /*
    @DeleteMapping(path = "/rest/deletetodo/{id}")
    public void delete(@PathVariable long id) {
        Long ToDoId = Long.parseLong(String.valueOf(id));
        toDoListService.deleteToDo(ToDoId);
    }
    */

    /*
    @DeleteMapping(path = "/rest/deletetodo/{id}")
    public ResponseEntity<Long> delete(@PathVariable long id) {
        var isRemoved = toDoListService.deleteToDo(id);

        if(!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    */

    @DeleteMapping(path = "/rest/deletetodo/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        toDoListService.deleteToDo(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
