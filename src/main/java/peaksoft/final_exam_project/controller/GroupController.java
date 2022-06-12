package peaksoft.final_exam_project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.final_exam_project.model.Course;
import peaksoft.final_exam_project.model.Group;
import peaksoft.final_exam_project.service.GroupService;

import java.util.List;

@Controller
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupService service;

    public GroupController(GroupService service) {
        this.service = service;
    }


    @RequestMapping
    public String viewGroupPage(Model model) {
        List<Group> groups = service.getAllGroups();

        model.addAttribute("groups", groups);
        return "group_page";
    }

    @GetMapping("/new")
    public String showPage(Model model) {

        Group group = new Group();
        model.addAttribute("group", group);

        return "new_group";
    }

    @PostMapping("/save")
    public String saveGroup(@ModelAttribute("group")Group group) {

        service.save(group);

        return "redirect:/api/groups";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable long id) {

        ModelAndView view = new ModelAndView("edit_group");
        Group group = service.getById(id);
        view.addObject("group", group);
        return view;
    }


    @RequestMapping("/delete/{id}")
    public String deleteGroup(@PathVariable long id) {
        service.delete(id);
        return "redirect:/api/groups";
    }



}
