package peaksoft.final_exam_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.final_exam_project.model.Company;
import peaksoft.final_exam_project.model.Course;
import peaksoft.final_exam_project.model.Student;
import peaksoft.final_exam_project.repository.CourseRepository;
import peaksoft.final_exam_project.repository.StudentRepository;

import java.util.ArrayList;
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

    public List<Course> findByCompanyId(Long companyId) {

        List<Course> courses = repository.findAll();
        List<Course> courses1 = new ArrayList<>();

        for (Course c : courses) {
            if (c.getCompany().getId() == companyId) {
                courses1.add(c);
            }
        }

        return courses1;
    }

    public void edit(Course course, Long courseId) {

//        repository.deleteById(courseId);
//
        course.setId(courseId);

        repository.save(course);


    }
}
