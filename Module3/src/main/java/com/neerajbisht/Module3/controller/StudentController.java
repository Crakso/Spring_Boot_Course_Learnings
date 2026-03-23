package com.neerajbisht.Module3.controller;

import com.neerajbisht.Module3.entity.dto.StudentDTO;
import com.neerajbisht.Module3.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDTO> findStudentById(@PathVariable Long studentId){
        StudentDTO student = studentService.findStudentById(studentId);
        return new ResponseEntity<>(student,
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<StudentDTO>> findAllStudents(
            @RequestParam(required = false,defaultValue = "0") Integer pageNumber,
            @RequestParam(required = false, defaultValue = "id") String sortBy ){

        Page<StudentDTO> students = studentService.findAllStudent(pageNumber,sortBy);
        return new ResponseEntity<>(students,
                HttpStatus.OK);
    }

}
