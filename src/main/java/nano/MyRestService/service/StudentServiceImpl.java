package nano.MyRestService.service;

import nano.MyRestService.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentServiceImpl implements StudentService {

    // Хранилище студентов
    private static final Map<Long, Student> STUDENT_REPOSITORY_MAP = new HashMap<>();

    // Переменная для генерации ID стундта
    private static final AtomicLong STUDENT_ID_HOLDER = new AtomicLong();

    @Override
    public void addStudent(Student student) {
        final Long studentId = STUDENT_ID_HOLDER.incrementAndGet();
        student.setId(studentId);
        STUDENT_REPOSITORY_MAP.put(studentId, student);
    }

    @Override
    public List<Student> readAll() {
        return new ArrayList<>(STUDENT_REPOSITORY_MAP.values());
    }

    @Override
    public boolean delete(Long id) {
        return STUDENT_REPOSITORY_MAP.remove(id) != null;
    }
}
