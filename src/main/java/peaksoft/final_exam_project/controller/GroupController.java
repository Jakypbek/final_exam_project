package peaksoft.final_exam_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.final_exam_project.model.Course;
import peaksoft.final_exam_project.model.Group;
import peaksoft.final_exam_project.service.CourseService;
import peaksoft.final_exam_project.service.GroupService;

import java.util.List;

@Controller
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupService groupService;
    private final CourseService courseService;

    public GroupController(GroupService groupService, CourseService courseService) {
        this.groupService = groupService;
        this.courseService = courseService;
    }

    @ModelAttribute("groupList")
    public List<Group> allGroups() {
        return groupService.getAllGroups();
    }
    @ModelAttribute("courseList")
    public List<Course> allCourses() {
        return courseService.getAllCourses();
    }

    @RequestMapping
    public String groupPage() {
        return "groupPage";
    }

    @GetMapping("/save")
    public String saveGroupPage(Model model) {

        model.addAttribute("emptyGroup", new Group());
        model.addAttribute("courses", courseService.getAllCourses());

        return "saveGroupPage";
    }

    @PostMapping("/save")
    public String saveGroup(Group group) {
        System.out.println(2222);
        groupService.save(group);


        return "redirect:/api/groups";
    }

    @GetMapping("/edit/{groupId}")
    public String editGroup(@PathVariable Long groupId, Model model) {

        Group group = groupService.getById(groupId);

        model.addAttribute("group", group);

        return "editGroup";
    }
    @PostMapping("/edit/{groupId}")
    public String editGroup(Group group, @PathVariable Long groupId) {


        groupService.edit(group, groupId);

        return "redirect:/api/groups";
    }
    @GetMapping("/delete/{groupId}")
    public String deleteGroup(@PathVariable Long groupId) {


        groupService.delete(groupId);

        return "redirect:/api/groups";
    }
}
