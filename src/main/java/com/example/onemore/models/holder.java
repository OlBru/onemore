package com.example.onemore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "holder")
public class holder {

    @Id
    @Column(name = "idof_holder")
    private Integer IDofHolder;

    @Column(name = "inn")
    private Integer NumbofINN;
    @Column(name = "type", columnDefinition = "varchar(50)")
    private String Type;
    @OneToMany(mappedBy = "holder")
    private List<account> Accounts;


}
