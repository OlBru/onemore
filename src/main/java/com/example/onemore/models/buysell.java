package com.example.onemore.models;

import lombok.NoArgsConstructor;
import java.sql.Date;

import jakarta.persistence.*;


@NoArgsConstructor
@Entity
@Table(name = "buysell")
public class buysell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idof_operation")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idof_account", referencedColumnName ="idof_account")
    private account account;



    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date Date;

    @Column(name = "type",columnDefinition = "varchar(30)")
    private String Type;

    @ManyToOne
    @JoinColumn(name = "idof_papers")
    private com.example.onemore.models.papers papers;


    @ManyToOne
    @JoinColumn(name = "idof_mediator")
    private com.example.onemore.models.mediator mediator;



}
