package peaksoft.final_exam_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.final_exam_project.model.Course;
import peaksoft.final_exam_project.model.Student;
import peaksoft.final_exam_project.repository.CourseRepository;
import peaksoft.final_exam_project.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;


    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public void save(Course course) {
        repository.save(course);
    }

    public Course getById(long id) {
        return repository.findById(id).get();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
