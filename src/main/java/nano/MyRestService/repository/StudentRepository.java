package nano.MyRestService.repository;

import nano.MyRestService.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {}
