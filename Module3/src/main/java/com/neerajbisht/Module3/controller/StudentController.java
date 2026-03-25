package com.neerajbisht.Module3.controller;

import com.neerajbisht.Module3.entity.dto.StudentDTO;
import com.neerajbisht.Module3.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

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

    @GetMapping("/get-all-students")
    public ResponseEntity<Page<StudentDTO>> findAllStudents(
            @RequestParam(required = false,defaultValue = "0") Integer pageNumber,
            @RequestParam(required = false, defaultValue = "id") String sortBy ){

        Page<StudentDTO> students = studentService.findAllStudent(pageNumber,sortBy);
        return new ResponseEntity<>(students,
                HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<StudentDTO> createNewStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO newStudent = studentService.createNewStudent(studentDTO);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long studentId,@RequestBody StudentDTO studentDTO){
        StudentDTO updatedStudent = studentService.updateStudentById(studentId,studentDTO);
        return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
    }

    @PatchMapping("/{studentId}/edit")
    public ResponseEntity<StudentDTO> patchStudent(@PathVariable Long studentId, Map<String, Objects> updates){
        StudentDTO patchedStudent = studentService.patchStudentById(studentId,updates);
        return new ResponseEntity<>(patchedStudent,HttpStatus.OK);
    }

}
