package peaksoft.final_exam_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.final_exam_project.model.Teacher;
import peaksoft.final_exam_project.repository.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository repository;


    public List<Teacher> getAllTeachers() {
        return repository.findAll();
    }

    public void save(Teacher teacher) {
        repository.save(teacher);
    }

    public Teacher getById(long id) {
        return repository.findById(id).get();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public void edit(Teacher teacher, Long teacherId) {

        repository.deleteById(teacherId);

        teacher.setId(teacherId);

        repository.save(teacher);
    }
}
