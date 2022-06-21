package peaksoft.final_exam_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.final_exam_project.model.Company;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Override
    <S extends Company> S save(S entity);

    @Override
    Optional<Company> findById(Long aLong);

    @Override
    List<Company> findAll();

    @Override
    void deleteById(Long aLong);


}