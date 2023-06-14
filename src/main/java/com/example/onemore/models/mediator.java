package com.example.onemore.models;

import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "mediator")
public class mediator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idof_mediator")
    private Integer IDofMediator;
    @Column(name = "inn")
    private Integer NumbofINN;
    @Column(name = "type",columnDefinition = "varchar(50)")
    private String Type;
    @OneToMany(mappedBy = "mediator")
    private List<buysell> buysells;


}
