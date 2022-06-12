package peaksoft.final_exam_project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.final_exam_project.model.Group;
import peaksoft.final_exam_project.model.Teacher;
import peaksoft.final_exam_project.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }


    @RequestMapping
    public String viewGroupPage(Model model) {
        List<Teacher> teachers = service.getAllTeachers();

        model.addAttribute("teachers", teachers);
        return "teacher_page";
    }

    @GetMapping("/new")
    public String showPage(Model model) {

        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);

        return "new_teacher";
    }

    @PostMapping("/save")
    public String saveTeacher(@ModelAttribute("teacher")Teacher teacher) {

        service.save(teacher);

        return "redirect:/api/teachers";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable long id) {

        ModelAndView view = new ModelAndView("edit_teacher");
        Teacher teacher = service.getById(id);
        view.addObject("teacher", teacher);
        return view;
    }


    @RequestMapping("/delete/{id}")
    public String deleteGroup(@PathVariable long id) {
        service.delete(id);
        return "redirect:/api/teachers";
    }



}
