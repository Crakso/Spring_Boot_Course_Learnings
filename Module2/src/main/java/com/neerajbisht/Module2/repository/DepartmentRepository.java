package com.neerajbisht.Module2.repository;

import com.neerajbisht.Module2.entity.Department;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByEmail(@Email String email);
}
