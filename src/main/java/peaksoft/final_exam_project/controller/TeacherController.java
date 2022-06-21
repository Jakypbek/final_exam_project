package peaksoft.final_exam_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.final_exam_project.model.Teacher;
import peaksoft.final_exam_project.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @ModelAttribute("teacherList")
    public List<Teacher> allTeachers() {
        return teacherService.getAllTeachers();
    }

    @RequestMapping
    public String teacherPage() {
        return "teacherPage";
    }

    @GetMapping("/save")
    public String saveTeacherPage(Model model) {

        model.addAttribute("emptyTeacher", new Teacher());

        return "saveTeacherPage";
    }

    @PostMapping("/save")
    public String saveTeacher(Teacher teacher) {

        teacherService.save(teacher);

        return "redirect:/api/teachers";
    }

    @GetMapping("/edit/{teacherId}")
    public String editTeacher(@PathVariable Long teacherId, Model model) {

        Teacher teacher = teacherService.getById(teacherId);

        model.addAttribute("teacher", teacher);

        return "editTeacher";
    }
    @PostMapping("/edit/{teacherId}")
    public String editTeacher(Teacher teacher, @PathVariable Long teacherId) {


        teacherService.edit(teacher, teacherId);

        return "redirect:/api/teachers";
    }
    @GetMapping("/delete/{teacherId}")
    public String delete(@PathVariable Long teacherId) {


        teacherService.delete(teacherId);

        return "redirect:/api/teachers";
    }
}
