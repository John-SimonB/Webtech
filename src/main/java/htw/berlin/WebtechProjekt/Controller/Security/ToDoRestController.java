package htw.berlin.WebtechProjekt.Controller.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import htw.berlin.WebtechProjekt.Models.CustomUserDetails;
import htw.berlin.WebtechProjekt.Models.ToDoListEntity;
import htw.berlin.WebtechProjekt.Models.ToDoUser;
import htw.berlin.WebtechProjekt.Repository.ToDoRepository;
import htw.berlin.WebtechProjekt.Repository.UserRepository;
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
}
