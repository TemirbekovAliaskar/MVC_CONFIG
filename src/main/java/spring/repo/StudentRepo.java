package spring.repo;

import spring.ebtity.Student;

import java.util.List;

public interface StudentRepo {
    List<Student> findAll();

    void save(Student student);

    Student findById(Long id);
    String updateById(Long id, Student newStudent);
    void deleteById(Long id);
}
