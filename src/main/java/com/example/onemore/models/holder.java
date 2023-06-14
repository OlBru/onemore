package com.example.onemore.models;

import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.List;
@NoArgsConstructor
@Entity
@Table(name = "holder")
public class holder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idof_holder")
    private Integer IDofHolder;

    @Column(name = "inn")
    private Integer NumbofINN;
    @Column(name = "type", columnDefinition = "varchar(50)")
    private String Type;
    @OneToMany(mappedBy = "holder")
    private List<account> Accounts;



}
