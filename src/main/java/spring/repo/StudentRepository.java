package spring.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.ebtity.Student;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class StudentRepository implements StudentRepo{
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public List<Student> findAll() {
        return entityManager
                .createQuery("select s from Student s", Student.class)
                .getResultList();
    }

    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Long id) {
        return entityManager.find(Student.class,id);
    }

        @Override
        public String updateById(Long id, Student newStudent) {
            Student student = entityManager.find(Student.class, id);
            student.setAge(newStudent.getAge());
            student.setFullName(newStudent.getFullName());
            student.setGender(newStudent.getGender());
            student.setImage(newStudent.getImage());
            return "Success!";
        }

    @Override
    public void deleteById(Long id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }


}
