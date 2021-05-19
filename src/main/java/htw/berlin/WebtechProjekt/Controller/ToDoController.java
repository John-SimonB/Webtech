package htw.berlin.WebtechProjekt.Controller;

import htw.berlin.WebtechProjekt.Services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ToDoController {

    @Autowired
    public ToDoListService toDoListService;

    @GetMapping(path = "/")
    public String showhome(Model model) {
        model.addAttribute("todos", toDoListService.findAll());
        return "home";
    }

    @GetMapping(path = "/createtodo")
    public String showcreatetodo(Model model) {
        return "createtodo";
    }

    @GetMapping(path = "/login")
    public String showlogin(Model model) {
        return "login";
    }

    @GetMapping(path = "/register")
    public String showregister(Model model) {
        return "register";
    }
}
