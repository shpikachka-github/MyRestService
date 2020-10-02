package nano.MyRestService.contollers;

import nano.MyRestService.form.StudentForm;
import nano.MyRestService.model.Student;
import nano.MyRestService.service.StudentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
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

    @RequestMapping(value = {"/students"}, method = RequestMethod.GET)
    public String studentsList(Model model) {
        List<Student> students = studentService.readAll();
        model.addAttribute("students", students);
        StudentForm studentForm = new StudentForm();
        model.addAttribute("studentForm", studentForm);
        return "students";
    }

    @RequestMapping(value = {"/students"}, method = RequestMethod.POST)
    public String addStudent(Model model,
                             @ModelAttribute("studentForm") StudentForm studentForm) {

        String fullName = studentForm.getFullName();
        String dateOfBirth = studentForm.getDateOfBirth();

        if (fullName != null && fullName.length() > 0
                && dateOfBirth != null && dateOfBirth.length() > 0) {
            Student newStudent = new Student(fullName, LocalDate.parse(dateOfBirth));
            studentService.add(newStudent);

            return "redirect:/students";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "students";
    }
}
