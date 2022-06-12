package peaksoft.final_exam_project.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.final_exam_project.model.Student;
import peaksoft.final_exam_project.service.StudentService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Student> students = service.getAllStudents();

        model.addAttribute("studentList", students);
        return "student_page";
    }

    @RequestMapping("/new")
    public String showPage(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);

        return "new_student";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student")Student student) {

        service.save(student);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable(name = "id") long id) {

        ModelAndView view = new ModelAndView("edit_student");
        Student student = service.getById(id);
        view.addObject("student", student);
        return view;
    }
    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(name = "id") long id) {
        service.delete(id);
        return "redirect:/";
    }


}
