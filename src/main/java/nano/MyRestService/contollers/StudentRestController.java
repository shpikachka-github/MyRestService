package nano.MyRestService.contollers;

import nano.MyRestService.model.Student;
import nano.MyRestService.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    private StudentRepository studentRepository;

    @Value("${welcome.message}")
    private String message;

    @GetMapping(value = {"/", "/index"})
    public String getMessage() {
        return message;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentRepository.findAllStudents();
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepository.myDeleteById(id);
        return String.valueOf(true);
    }
}
