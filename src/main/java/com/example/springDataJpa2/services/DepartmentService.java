package com.example.springDataJpa2.services;

import com.example.springDataJpa2.entities.DepartmentEntity;
import com.example.springDataJpa2.entities.EmployeeEntity;
import com.example.springDataJpa2.respositories.DepartmentRepository;
import com.example.springDataJpa2.respositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {


    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
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

    public DepartmentEntity assignManagerToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeId);

        return departmentEntity.flatMap(department->
                employeeEntity.map(employee->{
                    department.setManager(employee);
                    return departmentRepository.save(department);
                })
                ).orElse(null);
    }

    public DepartmentEntity getAssignedDepartmentToManager(Long employeeId) {
        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeId);
        return employeeEntity.map(employee->{
            return employee.getManagedDepartment();
        }).orElse(null);
    }

    public DepartmentEntity assignWorkerToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeId);

        return departmentEntity.flatMap(department->
                employeeEntity.map(employee->{
                    employee.setWorkerDepartment(department);
                    employeeRepository.save(employee);
                    department.getWorkers().add(employee);
                    return department;
                })
        ).orElse(null);
    }
}
