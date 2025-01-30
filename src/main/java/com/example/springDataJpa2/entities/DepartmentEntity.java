package com.example.springDataJpa2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity


@Table(name="departments")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public DepartmentEntity() {
    }

    public DepartmentEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    //foreign key referring to primary key of employee table
    @OneToOne
    @JoinColumn(name = "department_manager")
    private EmployeeEntity manager;

    public EmployeeEntity getManager() {
        return manager;
    }

    public void setManager(EmployeeEntity manager) {
        this.manager = manager;
    }

    @OneToMany(mappedBy = "workerDepartment")
    private Set<EmployeeEntity> workers;

    public Set<EmployeeEntity> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<EmployeeEntity> workers) {
        this.workers = workers;
    }
}
