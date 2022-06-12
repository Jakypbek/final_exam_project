package peaksoft.final_exam_project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.final_exam_project.model.Company;
import peaksoft.final_exam_project.model.Course;
import peaksoft.final_exam_project.service.CourseService;

import java.util.List;

@Controller
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }


    @RequestMapping
    public String viewCoursePage(Model model) {
        List<Course> courses = service.getAllCourses();

        model.addAttribute("courseList", courses);
        return "company_page";
    }

    @GetMapping("/new")
    public String showPage(Model model) {

        Course course = new Course();
        model.addAttribute("course", course);

        return "new_course";
    }

    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("course")Course course) {

        service.save(course);

        return "redirect:/api/courses";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable long id) {

        ModelAndView view = new ModelAndView("edit_course");
        Course course = service.getById(id);
        view.addObject("course", course);
        return view;
    }


    @RequestMapping("/delete/{id}")
    public String deleteCourse(@PathVariable long id) {
        service.delete(id);
        return "redirect:/api/courses";
    }



}
