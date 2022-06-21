package peaksoft.final_exam_project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String companyName;
    private String locatedCountry;

    @OneToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH
    }, mappedBy = "company")
    private List<Course> courses = new ArrayList<>();

    public void setCourse(Course course) {
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return companyName;
    }
}
