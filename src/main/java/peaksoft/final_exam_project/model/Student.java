package peaksoft.final_exam_project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import peaksoft.final_exam_project.model.enam.StudyFormat;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Getter@Setter
@NoArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String email;
    private String lastName;
    private StudyFormat studyFormat;

    @ManyToOne
    private Group group;
}
