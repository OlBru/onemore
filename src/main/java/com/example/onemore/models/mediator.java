package com.example.onemore.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "mediator")
public class mediator {

    @Id
    @Column(name = "idof_mediator")
    private Integer IDofMediator;
    @Column(name = "inn")
    private Integer NumbofINN;
    @Column(name = "type",columnDefinition = "varchar(50)")
    private String Type;
    @OneToMany(mappedBy = "mediator")
    private List<buysell> buysells;


}
