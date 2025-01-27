package com.example.springDataJpa2.controllers;

import com.example.springDataJpa2.entities.DepartmentEntity;
import com.example.springDataJpa2.entities.EmployeeEntity;
import com.example.springDataJpa2.services.DepartmentService;
import com.example.springDataJpa2.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/sample")
    public String getSample(){
        return "Hello";
    }

    @GetMapping()
    public List<DepartmentEntity> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{deptId}")
    public DepartmentEntity getDepartmentById(@PathVariable Long deptId){
        return departmentService.getDepartmentById(deptId);
    }

    @PostMapping()
    public DepartmentEntity addNewDepartment(@RequestBody DepartmentEntity departmentEntity){
        return departmentService.createNewDepartment(departmentEntity);
    }
}
