package com.example.springDataJpa2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(mappedBy = "manager")
    @JsonIgnore
    private DepartmentEntity managedDepartment;

    public DepartmentEntity getManagedDepartment() {
        return managedDepartment;
    }

    public void setManagedDepartment(DepartmentEntity managedDepartment) {
        this.managedDepartment = managedDepartment;
    }

    @ManyToOne
    @JoinColumn(name = "worker_department_Id",referencedColumnName = "id")
    @JsonIgnore
    private DepartmentEntity workerDepartment;

    public DepartmentEntity getWorkerDepartment() {
        return workerDepartment;
    }

    public void setWorkerDepartment(DepartmentEntity workerDepartment) {
        this.workerDepartment = workerDepartment;
    }

    public EmployeeEntity(DepartmentEntity workerDepartment) {
        this.workerDepartment = workerDepartment;
    }
}
