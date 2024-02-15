package spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.ebtity.Student;
import spring.repo.StudentRepo;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceIMpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public Student findById(Long studentId) {
        return studentRepo.findById(studentId);
    }

    @Override
    public String updateById(Long id, Student newStudent) {
        return studentRepo.updateById(id, newStudent);
    }

    @Override
    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }


}
