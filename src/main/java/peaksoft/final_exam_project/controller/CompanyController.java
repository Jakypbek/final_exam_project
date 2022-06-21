package peaksoft.final_exam_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.final_exam_project.model.Company;
import peaksoft.final_exam_project.service.CompanyService;
import peaksoft.final_exam_project.service.CourseService;

import java.util.List;

@Controller
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @ModelAttribute("companyList")
    public List<Company> allCompanies() {
        return companyService.getAllCompanies();
    }

    @RequestMapping
    public String companyPage() {
        return "companyPage";
    }

    @GetMapping("/save")
    public String saveCompanyPage(Model model) {

        model.addAttribute("emptyCompany", new Company());

        return "saveCompanyPage";
    }

    @PostMapping("/save")
    public String saveCompany(Company company) {

        companyService.save(company);

        return "redirect:/api/companies";
    }

    @GetMapping("/edit/{companyId}")
    public String editCompany(@PathVariable Long companyId, Model model) {

        Company company = companyService.getById(companyId);

        model.addAttribute("company", company);

        return "editCompany";
    }
    @PostMapping("/edit/{companyId}")
    public String editCompany(Company company, @PathVariable Long companyId) {


        companyService.edit(company, companyId);

        return "redirect:/api/companies";
    }
    @GetMapping("/delete/{companyId}")
    public String saveStuddfvent(@PathVariable Long companyId) {


        companyService.delete(companyId);

        return "redirect:/api/companies";
    }

}
