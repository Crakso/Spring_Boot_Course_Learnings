package com.neerajbisht.Module3.repository;

import com.neerajbisht.Module3.entity.ProfessorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {

    Page<ProfessorEntity> findBy(Pageable pageable);

}