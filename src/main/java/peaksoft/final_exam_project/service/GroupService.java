package peaksoft.final_exam_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.final_exam_project.model.Course;
import peaksoft.final_exam_project.model.Group;
import peaksoft.final_exam_project.repository.CourseRepository;
import peaksoft.final_exam_project.repository.GroupRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository repository;


    public List<Group> getAllGroups() {
        return repository.findAll();
    }

    public void save(Group group) {
        repository.save(group);
    }

    public Group getById(long id) {
        return repository.findById(id).get();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
