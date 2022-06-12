package peaksoft.final_exam_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.final_exam_project.model.Course;
import peaksoft.final_exam_project.model.Group;
import peaksoft.final_exam_project.model.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Override
    <S extends Group> S save(S entity);

    @Override
    Optional<Group> findById(Long aLong);

    @Override
    List<Group> findAll();

    @Override
    void deleteById(Long aLong);

}