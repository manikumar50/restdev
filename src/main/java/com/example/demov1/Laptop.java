package com.example.demov1;

import jakarta.persistence.*;

@Entity
public class Laptop
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lapName;

    @OneToOne(mappedBy = "laptop")
    private Employee employee;
}