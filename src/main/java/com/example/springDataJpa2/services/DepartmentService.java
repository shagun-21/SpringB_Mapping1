package com.example.springDataJpa2.services;

import com.example.springDataJpa2.entities.DepartmentEntity;
import com.example.springDataJpa2.respositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {


    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    public DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity){
        return departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity getDepartmentById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }

    public List<DepartmentEntity> getAllDepartments() {

        List<DepartmentEntity> result= departmentRepository.findAll();
        System.out.println("fetched:"+ result);
        return result;
    }
}
