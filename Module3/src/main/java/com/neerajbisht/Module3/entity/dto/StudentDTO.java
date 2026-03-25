package com.neerajbisht.Module3.entity.dto;

import com.neerajbisht.Module3.entity.ProfessorEntity;
import com.neerajbisht.Module3.entity.SubjectEntity;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class StudentDTO {

    private Long id;

    private String name;

    private List<ProfessorEntity> professors;

    private List<SubjectEntity> subjects;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
