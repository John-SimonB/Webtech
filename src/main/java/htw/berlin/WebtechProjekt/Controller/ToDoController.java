package htw.berlin.WebtechProjekt.Controller;

import htw.berlin.WebtechProjekt.Models.ToDoListEntity;
import htw.berlin.WebtechProjekt.Models.ToDoUser;
import htw.berlin.WebtechProjekt.Repository.ToDoRepository;
import htw.berlin.WebtechProjekt.Repository.UserRepository;
import htw.berlin.WebtechProjekt.Services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ToDoController {

    @Autowired
    public ToDoListService toDoListService;
    @Autowired
    public ToDoRepository toDoRepository;
    @Autowired
    public UserRepository userRepository;


    @GetMapping(path = "/")
    public String showhome(Model model) {
        return "home";
    }

    @GetMapping(path = "/todos")
    public String showtodo(Model model) {
        List<ToDoListEntity> todo =toDoListService.findAll();
        model.addAttribute("todos", toDoListService.findAll());
        return "todos";
    }

    @GetMapping(path = "/createtodo")
    public String showcreatetodo(@ModelAttribute Model model, ToDoListEntity toDoListEntity) {
        toDoRepository.save(toDoListEntity);
        model.addAttribute("todo", toDoListEntity);
        return "createtodo";
    }

    @GetMapping(path = "/login")
    public String showlogin() {
        return "login";
    }

    @GetMapping(path = "/registration")
    public String showRegistrationPage(Model model) {
        //userService.createUser(registrationRequest());
        model.addAttribute("toDoUser", new ToDoUser());
        return "register";
    }

    @PostMapping(path = "/registration_process")
    public String handleRegistrationRequest(ToDoUser toDoUser) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(toDoUser.getPassword());
        toDoUser.setPassword(encodedPassword);
        userRepository.save(toDoUser);
        return  "registrationSuccessful";
    }

    @GetMapping("/list_users")
    public String viewUserList(Model model) {
        List<ToDoUser> listUsers = userRepository.findAll();
        model.addAttribute("listUsers", listUsers);
        return "userlist";
    }

}
