package com.mdymen.jpaauxtable.employee;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_info")
@SecondaryTable(name = "employee_address", pkJoinColumns = @PrimaryKeyJoinColumn(name = "employee_id"))
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(table = "employee_info")
    private String department;

    @Column(table = "employee_info")
    private double salary;

    @Column(table = "employee_address")
    private String city;

    @Column(table = "employee_address")
    private String street;

    // Constructors, getters, setters...
}