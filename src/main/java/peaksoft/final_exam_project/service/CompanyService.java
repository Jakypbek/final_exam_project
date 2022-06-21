package peaksoft.final_exam_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.final_exam_project.model.Company;
import peaksoft.final_exam_project.model.Student;
import peaksoft.final_exam_project.repository.CompanyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository repository;

    public List<Company> getAllCompanies() {
        return repository.findAll();
    }

    public void save(Company company) {
        repository.save(company);
    }

    public Company getById(long id) {
        return repository.findById(id).get();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }


    public void edit(Company company, Long companyId) {


        repository.deleteById(companyId);

        company.setId(companyId);

        repository.save(company);

    }
}
