package peaksoft.final_exam_project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String courseName;
    private int duration;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH}, mappedBy = "courses")
    private List<Group> groups = new ArrayList<>();

    @OneToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST}, mappedBy = "course")
    private Teacher teacher;

    public void setGroup(Group group) {
        this.groups.add(group);
    }

}
