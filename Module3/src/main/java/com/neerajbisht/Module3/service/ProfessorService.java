package com.neerajbisht.Module3.service;

import com.neerajbisht.Module3.entity.ProfessorEntity;
import com.neerajbisht.Module3.exception.ResourceNotFoundException;
import com.neerajbisht.Module3.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorEntity registerProfessor(ProfessorEntity professorEntity){
        return professorRepository.save(professorEntity);
    }

    public void deleteProfessor(Long professorId){
        professorRepository.deleteById(professorId);
    }

    public ProfessorEntity findProfessorById(Long professorId){
        return professorRepository.findById(professorId).orElseThrow(()->
                new ResourceNotFoundException("Professor not found with this professorId "+professorId));
    }
    public Page<ProfessorEntity> getAllProfessors(Integer pageNumber){
        final int pageSize =5;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC));
        return professorRepository.findBy(pageable);
    }
}
