package nano.MyRestService.repository;

import nano.MyRestService.model.Student;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("select * from students where full_name:=fullName;")
    List<Student> findByFullName(@Param("fullName") String fullName);

    //TODO
}
