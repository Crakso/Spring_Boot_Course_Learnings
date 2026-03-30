package com.neerajbisht.Module3.repository;

import com.neerajbisht.Module3.entity.AdmissionRecordEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecordEntity, Long> {
Page<AdmissionRecordEntity> findBy(Pageable pageable);
}