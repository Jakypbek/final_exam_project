package peaksoft.final_exam_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.final_exam_project.model.Student;
import peaksoft.final_exam_project.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;


    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public void save(Student student) {
        repository.save(student);
    }

    public Student getById(long id) {
        return repository.findById(id).get();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public void edit(Student student, Long studentId) {

//        repository.deleteById(studentId);

        student.setId(studentId);

        repository.save(student);
    }
}