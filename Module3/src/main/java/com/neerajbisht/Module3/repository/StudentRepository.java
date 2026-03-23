package com.neerajbisht.Module3.repository;

import com.neerajbisht.Module3.entity.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    Page<StudentEntity> findAllStudents(Pageable pageable);
}
