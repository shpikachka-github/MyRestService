package nano.MyRestService.service;

import nano.MyRestService.model.Student;

import java.util.List;

public interface StudentService {

    /**
     * Добавление студента
     * @param student - студент для добавления
     */
    void add(Student student);

    /**
     * Возвращает список всех имеющихся студентов
     * @return список студентов
     */
    List<Student> readAll();

    /**
     * Удаляет студента с заданным ID
     * @param id - id студента, которого нужно удалить
     * @return - true если студент был удален, иначе false
     */
    boolean delete(Long id);
}
