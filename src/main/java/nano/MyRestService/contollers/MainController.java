package nano.MyRestService.contollers;

import nano.MyRestService.model.Student;
import nano.MyRestService.service.StudentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

    private final StudentService studentService;

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    public MainController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = {"/studentsList"}, method = RequestMethod.GET)
    public String studentsList(Model model) {
        final List<Student> students = studentService.readAll();

        model.addAttribute("students", students);

        return "studentsList";
    }
}
