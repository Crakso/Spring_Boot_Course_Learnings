package com.neerajbisht.Module3.service;

import com.neerajbisht.Module3.entity.StudentEntity;
import com.neerajbisht.Module3.entity.dto.StudentDTO;
import com.neerajbisht.Module3.exception.ResourceNotFoundException;
import com.neerajbisht.Module3.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final Integer PageSize = 5;

    public StudentDTO findStudentById(Long id){
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student is not exist with this id: "+ id));

        return modelMapper.map(student,StudentDTO.class);
    }

    public Page<StudentDTO> findAllStudent(Integer pageNumber, String sortBy) {

        Pageable pageable = PageRequest.of(pageNumber, PageSize, Sort.by(sortBy));

        Page<StudentEntity> students = studentRepository.findAllStudents(pageable);

        return students.map(student-> modelMapper.map(student,StudentDTO.class));
    }
}
