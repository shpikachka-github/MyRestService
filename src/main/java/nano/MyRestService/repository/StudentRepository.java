package nano.MyRestService.repository;

import nano.MyRestService.model.Student;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("select * from students")
    List<Student> findAllStudents();

    @Modifying
    @Query("delete from students where id = :id")
    void myDeleteById(@Param("id") Long id);
}
