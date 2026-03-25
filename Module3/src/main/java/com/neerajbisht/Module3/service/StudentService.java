package com.neerajbisht.Module3.service;

import com.neerajbisht.Module3.entity.StudentEntity;
import com.neerajbisht.Module3.entity.dto.StudentDTO;
import com.neerajbisht.Module3.exception.ResourceNotFoundException;
import com.neerajbisht.Module3.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;


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

    public StudentDTO createNewStudent(StudentDTO studentDTO){
        StudentEntity student = modelMapper.map(studentDTO, StudentEntity.class);
        if(studentRepository.existsById(student.getId())) throw new RuntimeException("Student is already exists with this id "+student.getId());
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDTO.class);
    }

    public StudentDTO updateStudentById(Long studentId, StudentDTO studentDTO){
        isValidUser(studentId);
        StudentEntity student = modelMapper.map(studentDTO, StudentEntity.class);
        student.setId(studentId);
        student = studentRepository.save(student);
        return modelMapper.map(student,StudentDTO.class);
    }

    public void deleteStudentById(Long studentId){
        isValidUser(studentId);
        studentRepository.deleteById(studentId);
    }

    public StudentDTO patchStudentById(Long studentId, Map<String, Objects> update){
        StudentEntity student = studentRepository.findById(studentId).orElseThrow(()->
                new ResourceNotFoundException("Student is not exist with this id: "+ studentId));

        update.forEach((field,value)-> {
                    Field fieldToBeUpdated = ReflectionUtils.findField(StudentEntity.class, field);
                    fieldToBeUpdated.setAccessible(true);
                    ReflectionUtils.setField(fieldToBeUpdated,student,value);
                });
        return modelMapper.map(studentRepository.save(student), StudentDTO.class);

    }


    private void isValidUser(Long studentId) {
        studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("Student is not exist with this id: "+ studentId));
    }


}
