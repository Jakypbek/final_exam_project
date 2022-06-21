package peaksoft.final_exam_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.final_exam_project.model.Student;
import peaksoft.final_exam_project.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ModelAttribute("studentList")
    public List<Student> allStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping
    public String studentPage() {
        return "studentPage";
    }

    @GetMapping("/save")
    public String saveStudentPage(Model model) {

        model.addAttribute("emptyStudent", new Student());

        return "saveStudentPage";
    }

    @PostMapping("/save")
    public String saveStudent(Student student) {

        studentService.save(student);

        return "redirect:/api/students";
    }

    @GetMapping("/edit/{studentId}")
    public String editStudent(@PathVariable Long studentId, Model model) {

        Student student = studentService.getById(studentId);

        model.addAttribute("student", student);

        return "editStudent";
    }

    @PostMapping("/edit/{studentId}")
    public String editStudent(Student student, @PathVariable Long studentId) {


        studentService.edit(student, studentId);

        return "redirect:/api/students";
    }
    @GetMapping("/delete/{studentId}")
    public String delete(@PathVariable Long studentId) {


        studentService.delete(studentId);

        return "redirect:/api/students";
    }
}
