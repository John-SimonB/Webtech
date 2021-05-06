package htw.berlin.WebtechProjekt.Controller;

import htw.berlin.WebtechProjekt.services.ToDoListImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoRestController {

    @GetMapping(path = "/list")
    public ResponseEntity<ToDoListImpl> List() {

        return ResponseEntity.ok(list);
    }

    /*@GetMapping(path = "list/completedtasks")
    public ResponseEntity<CompletedList> getCompletedToDoTasks(){
        return (ResponseEntity<CompletedList>) ResponseEntity.ok();
    }*/
}