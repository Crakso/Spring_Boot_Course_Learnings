package com.neerajbisht.Module3.repository;

import com.neerajbisht.Module3.entity.SubjectEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
    Page findBy(Pageable pageable);
}