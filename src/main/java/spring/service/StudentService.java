package spring.service;

import spring.ebtity.Student;
import spring.repo.StudentRepo;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    void save(Student student);

    Student findById(Long studentId);
    String updateById(Long id, Student newStudent);
    void deleteById(Long id);
}
