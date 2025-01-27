package com.example.springDataJpa2.services;

import com.example.springDataJpa2.entities.EmployeeEntity;
import com.example.springDataJpa2.respositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeEntity createNewEmployee(EmployeeEntity employeeEntity){
        return employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

}
