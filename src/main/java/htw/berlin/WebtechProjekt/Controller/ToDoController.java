package htw.berlin.WebtechProjekt.Controller;

import com.sun.xml.bind.v2.TODO;
import htw.berlin.WebtechProjekt.Models.ToDoListEntity;
import htw.berlin.WebtechProjekt.Models.ToDoUser;
import htw.berlin.WebtechProjekt.Registration.RegistrationRequest;
import htw.berlin.WebtechProjekt.Repository.ToDoRepository;
import htw.berlin.WebtechProjekt.Services.ToDoListService;
import htw.berlin.WebtechProjekt.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ToDoController {

    private final UserService userService;


    public ToDoController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public ToDoListService toDoListService;
    public ToDoUser toDoUser;
    public ToDoRepository toDoRepository;

    @GetMapping(path = "/")
    public String showhome(Model model) {
        List<ToDoListEntity> todo =toDoListService.findAll();
        model.addAttribute("todos", toDoListService.findAll());
        return "home";
    }

    @GetMapping(path = "/createtodo")
    public String showcreatetodo(@ModelAttribute Model model, ToDoListEntity toDoListEntity) {
        toDoRepository.save(toDoListEntity);
        model.addAttribute("todo", toDoListEntity);
        return "createtodo";
    }

    @GetMapping(path = "/login")
    public String showlogin(Model model) {
        return "login";
    }

    @GetMapping(path = "/registration")
    public String showRegistrationPage(@ModelAttribute Model model) {
        userService.createUser(registrationRequest());
        model.addAttribute("toDoUser", toDoUser);
        return "register";
    }

    @PostMapping(path = "registration")
    public String handleRegistrationRequest(RegistrationRequest registrationRequest) {
        userService.createUser(registrationRequest);
        return  "?registrationSuccessful";
    }

    @ModelAttribute(name = "registrationRequest")
    public RegistrationRequest registrationRequest() {
        return new RegistrationRequest();
    }
}
