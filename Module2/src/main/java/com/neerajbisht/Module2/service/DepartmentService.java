package com.neerajbisht.Module2.service;

import com.neerajbisht.Module2.dto.DepartmentDTO;
import com.neerajbisht.Module2.entity.Department;
import com.neerajbisht.Module2.exception.ResourceAlreadyExist;
import com.neerajbisht.Module2.exception.ResourceNotFoundException;
import com.neerajbisht.Module2.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public List<DepartmentDTO> getAllDepartment(){
        try {
            List<Department> department = departmentRepository.findAll();
            return department.stream().map(dep-> modelMapper.map(dep,DepartmentDTO.class)).collect(Collectors.toList());
        }catch (Exception e) {throw new IllegalArgumentException(e);}
    }

    public DepartmentDTO getDepartmentById(Long departmentId) {
        try {
            Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Invalid Department Id"));
            return modelMapper.map(department, DepartmentDTO.class);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public DepartmentDTO createDepartment(DepartmentDTO department){
        log.trace("Creating department with department info {}", department);
        try {
            Department isExist = departmentRepository.findByEmail(department.getEmail());
            if(isExist != null) throw new ResourceAlreadyExist("department already registered.");
            Department new_dep = modelMapper.map(department, Department.class);
            log.info("Saving department with department info");
            Department saved_dep = departmentRepository.save(new_dep);
            log.debug("Department is created successfully with department info {}.", saved_dep);
            return modelMapper.map(saved_dep, DepartmentDTO.class);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    public DepartmentDTO updateDepartmentById(Long departmentId, DepartmentDTO department) {
        try {
            checkDepartmentExists(departmentId);
            Department dep = modelMapper.map(department,Department.class);
            dep.setId(departmentId);
            Department saved_dep = departmentRepository.save(dep);
            return modelMapper.map(saved_dep, DepartmentDTO.class);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
    public void deleteDepartmentById(Long departmentId){
        try {
            checkDepartmentExists(departmentId);
            departmentRepository.deleteById(departmentId);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    public void checkDepartmentExists(Long departmentId){
        departmentRepository.findById(departmentId).orElseThrow(()-> new ResourceNotFoundException("Invalid Department Id"));
    }


}
