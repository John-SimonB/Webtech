package htw.berlin.WebtechProjekt;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoRestController {

    @GetMapping(path = "/list")
    public ResponseEntity<ToDolist> getToDoList(){
        return (ResponseEntity<ToDolist>) ResponseEntity.ok();
    }

    @GetMapping(path = "list/completedtasks")
    public ResponseEntity<CompletedList> getCompletedToDoTasks(){
        return (ResponseEntity<CompletedList>) ResponseEntity.ok();
    }
}