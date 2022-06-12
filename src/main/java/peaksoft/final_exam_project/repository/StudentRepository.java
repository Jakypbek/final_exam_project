package peaksoft.final_exam_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.final_exam_project.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Override
    <S extends Student> S save(S entity);

    @Override
    Optional<Student> findById(Long aLong);

    @Override
    List<Student> findAll();

    @Override
    void deleteById(Long aLong);


}
