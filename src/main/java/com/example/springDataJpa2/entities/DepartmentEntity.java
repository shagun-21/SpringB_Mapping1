package com.example.springDataJpa2.entities;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="departments")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
}
