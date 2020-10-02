package nano.MyRestService.contollers;

import nano.MyRestService.model.Student;
import nano.MyRestService.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainRestController {

    private final StudentService studentService;

    public MainRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/students/xml")
    public ResponseEntity<?> add(@RequestBody Student student) {
        studentService.add(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/students/xml")
    @ResponseBody
    public ResponseEntity<List<Student>> read() {
        final List<Student> students = studentService.readAll();

        return students != null &&  !students.isEmpty()
                ? new ResponseEntity<>(students, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/students/xml/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final boolean deleted = studentService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}

