package com.neerajbisht.Module2.controller;

import com.neerajbisht.Module2.dto.DepartmentDTO;
import com.neerajbisht.Module2.entity.Department;
import com.neerajbisht.Module2.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAllDepartments(){
        return new ResponseEntity<>(departmentService.getAllDepartment(), HttpStatus.OK);
    }

    @GetMapping(path = "{departmentId}")
    public ResponseEntity<DepartmentDTO> findDepartmentById(@PathVariable Long departmentId){
        return new ResponseEntity<>(departmentService.getDepartmentById(departmentId),HttpStatus.OK);
    }

    @PutMapping(path = "{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@PathVariable Long departmentId, @RequestBody DepartmentDTO department){
        return new ResponseEntity<>(departmentService.updateDepartmentById(departmentId,department),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody @Valid DepartmentDTO department){
        return new ResponseEntity<>(departmentService.createDepartment(department),HttpStatus.OK);
    }

    @DeleteMapping(path = "{departmentId}")
    public ResponseEntity<Void> deleteDepartmentById(@PathVariable Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
