package peaksoft.final_exam_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.final_exam_project.model.Group;
import peaksoft.final_exam_project.repository.GroupRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository repository;


    public List<Group> getAllGroups() {
        return repository.findAll();
    }
    @Transactional
    public void save(Group group) {
        repository.save(group);
        System.out.println(1111);
    }

    public Group getById(long id) {
        return repository.findById(id).get();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public void edit(Group group, Long groupId) {



//        repository.deleteById(groupId);

        group.setId(groupId);

        repository.save(group);
    }
}
