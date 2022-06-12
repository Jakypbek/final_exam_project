package peaksoft.final_exam_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.final_exam_project.model.Group;
import peaksoft.final_exam_project.model.Student;
import peaksoft.final_exam_project.model.Teacher;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Override
    <S extends Teacher> S save(S entity);

    @Override
    Optional<Teacher> findById(Long aLong);

    @Override
    List<Teacher> findAll();

    @Override
    void deleteById(Long aLong);
}