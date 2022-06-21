package peaksoft.final_exam_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.final_exam_project.model.Course;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Override
    <S extends Course> S save(S entity);

    @Override
    Optional<Course> findById(Long aLong);

    @Override
    List<Course> findAll();

    @Override
    void deleteById(Long aLong);
}