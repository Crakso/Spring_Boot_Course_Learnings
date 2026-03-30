package com.neerajbisht.Module3.service;

import com.neerajbisht.Module3.entity.AdmissionRecordEntity;
import com.neerajbisht.Module3.exception.ResourceNotFoundException;
import com.neerajbisht.Module3.repository.AdmissionRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdmissionRecordsService {
private final AdmissionRecordRepository admissionRecordRepository;

    public AdmissionRecordEntity registerAdmissionRecord(AdmissionRecordEntity admissionRecord){
        log.info("registering a admission record {}", admissionRecord);
        if(admissionRecord.getStudent() == null) throw new RuntimeException("Invalid AdmissionRecord");
        log.info("New admission record is registered successfully.");
        return admissionRecordRepository.save(admissionRecord);
    }

    public Page<AdmissionRecordEntity> findAllRepository(Integer pageNumber, String sortby){
        final int pageSize = 5;
        log.info("fetching the admission record for page number {}",pageNumber+1);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC,sortby));
        Page<AdmissionRecordEntity> allRecords = admissionRecordRepository.findBy(pageable);
        log.info("All records are fetched successfully.");
        return allRecords;
    }

    public AdmissionRecordEntity findAdmissionById(Long admissionId){
        log.info("fetching admission record with id {}", admissionId);
        AdmissionRecordEntity admissionRecord = admissionRecordRepository.findById(admissionId).orElseThrow(()->
                new ResourceNotFoundException("Admission not found invalid admission record id "+admissionId));
        log.info("admission record is fetched successfully.");
        return admissionRecord;
    }

    public void deleteAdmissionRecordById(Long admissionId){
        log.info("Fetching information with this id {}", admissionId);
        if(!admissionRecordRepository.existsById(admissionId))
            throw new ResourceNotFoundException("admission record is not found with this id "+ admissionId);
        admissionRecordRepository.deleteById(admissionId);
        log.info("Admission record with id {} is deleted successfully.",admissionId);
    }
}
