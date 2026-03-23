package com.neerajbisht.Module3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @OneToMany(mappedBy = "professor")
    private List<SubjectEntity> subjects;

    @ManyToMany
    @JoinTable(
            name = "student_professor_id",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<StudentEntity> students;
}
