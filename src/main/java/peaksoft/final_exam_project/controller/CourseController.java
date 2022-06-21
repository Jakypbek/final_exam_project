package peaksoft.final_exam_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.final_exam_project.model.Company;
import peaksoft.final_exam_project.model.Course;
import peaksoft.final_exam_project.service.CompanyService;
import peaksoft.final_exam_project.service.CourseService;

import java.util.List;

@Controller
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;
    private final CompanyService companyService;

    public CourseController(CourseService courseService, CompanyService companyService) {
        this.courseService = courseService;
        this.companyService = companyService;
    }

    @ModelAttribute("courseList")
    public List<Course> allCourses() {
        return courseService.getAllCourses();
    }
    @ModelAttribute("companyList")
    public List<Company> allCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping
    public String coursePage() {
        return "coursePage";
    }

    @GetMapping("/save")
    public String saveCoursePage(Model model) {


        model.addAttribute("emptyCourse", new Course());

        return "saveCoursePage";
    }

    @PostMapping("/save")
    public String saveCourse(Course course) {

        courseService.save(course);

        return "redirect:/api/courses";
    }

    @GetMapping("/edit/{courseId}")
    public String editCourse(@PathVariable Long courseId, Model model) {

        Course course = courseService.getById(courseId);

        model.addAttribute("course", course);

        return "editCourse";
    }
    @PostMapping("/edit/{courseId}")
    public String editCourse(Course course, @PathVariable Long courseId) {


        courseService.edit(course, courseId);

        return "redirect:/api/courses";
    }
    @GetMapping("/delete/{courseId}")
    public String deleteCourse(@PathVariable Long courseId) {


        courseService.delete(courseId);

        return "redirect:/api/courses";
    }
}
