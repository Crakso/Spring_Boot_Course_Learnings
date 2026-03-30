package com.neerajbisht.Module3.service;

import com.neerajbisht.Module3.entity.SubjectEntity;
import com.neerajbisht.Module3.exception.ResourceNotFoundException;
import com.neerajbisht.Module3.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private Integer pageSize = 5;

    public SubjectEntity createSubject(SubjectEntity subject){
        log.info("Creating {} subject.", subject.getTitle());
        SubjectEntity newSubject = subjectRepository.save(subject);
        log.info("New Subject is created successfully. {}", newSubject);
        return newSubject;
    }

    public SubjectEntity getSubjectById(Long subjectId){
    log.info("Finding Subject information using subject id {} ", subjectId);
       SubjectEntity subject = subjectRepository.findById(subjectId)
               .orElseThrow(()-> new ResourceNotFoundException("Invalid Subject id: "+ subjectId));
        log.info("Subject information is fetched successfully {}", subject);
       return subject;
    }

    public Page<SubjectEntity> getAllSubjects(Integer pageNumber, String sortBy){
        log.info("fetching all the subjects.");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC,sortBy));
        Page<SubjectEntity> subjects = subjectRepository.findBy(pageable);
        log.info("subjects is fetched successfully.");
        return subjects;
    }

    public SubjectEntity updateSubject(Long subjectId, SubjectEntity subject){
        log.info("updating subject with subject id {}", subjectId);
        if(!subjectRepository.existsById(subjectId)) throw new  ResourceNotFoundException("Invalid subject id: "+subjectId);
        subject.setId(subjectId);
        log.info("Subject is updated successfully {}",subject);
        return subjectRepository.save(subject);
    }

    public void deleteSubject(Long subjectId){
        log.info("deleting subject with subject id {}", subjectId);
        subjectRepository.deleteById(subjectId);
        log.info("Subject is deleted successfully.");
    }

}
