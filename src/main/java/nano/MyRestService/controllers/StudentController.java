package nano.MyRestService.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class StudentController {

    @Value("${welcome.message}")
    private String message;

    @GetMapping(value = {"/", "index"})
    public String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }
}
