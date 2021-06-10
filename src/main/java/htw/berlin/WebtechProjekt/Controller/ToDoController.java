package htw.berlin.WebtechProjekt.Controller;

import htw.berlin.WebtechProjekt.Models.CustomUserDetails;
import htw.berlin.WebtechProjekt.Models.ToDoListEntity;
import htw.berlin.WebtechProjekt.Models.ToDoUser;
import htw.berlin.WebtechProjekt.Repository.ToDoRepository;
import htw.berlin.WebtechProjekt.Repository.UserRepository;
import htw.berlin.WebtechProjekt.Services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public List<ToDoListEntity> allToDos(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails toDoUser = (CustomUserDetails) authentication.getPrincipal();
        return toDoListService.findAll(toDoUser.getUsername());
    }

    @PostMapping(path = "/todos")
    public ToDoListEntity createTodo(ToDoListEntity toDoListEntity){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails toDoUser = (CustomUserDetails) authentication.getPrincipal();
        toDoListEntity.setOwner(toDoUser.getUsername());
        return toDoListService.save(toDoListEntity);
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
