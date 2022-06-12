package peaksoft.final_exam_project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.final_exam_project.model.Company;
import peaksoft.final_exam_project.model.Student;
import peaksoft.final_exam_project.service.CompanyService;

import java.util.List;

@Controller
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @RequestMapping
    public String viewCompanyPage(Model model) {
        List<Company> companies = service.getAllCompanies();

        model.addAttribute("companyList", companies);
        return "company_page";
    }

    @GetMapping("/new")
    public String showPage(Model model) {

        Company company = new Company();
        model.addAttribute("company", company);

        return "new_company";
    }

    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("company")Company company) {

        service.save(company);

        return "redirect:/api/companies";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable long id) {

        ModelAndView view = new ModelAndView("edit_company");
        Company company = service.getById(id);
        view.addObject("company", company);
        return view;
    }


    @RequestMapping("/delete/{id}")
    public String deleteCompany(@PathVariable long id) {
        service.delete(id);
        return "redirect:/api/companies";
    }


}
