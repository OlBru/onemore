package com.example.onemore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Setter;


@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "buysell")
public class buysell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idof_operation")
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idof_account", referencedColumnName = "idof_account")
    private account account;


    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date Date;

    @Column(name = "type", columnDefinition = "varchar(30)")
    private String Type;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idof_papers")
    private com.example.onemore.models.papers papers;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idof_mediator")
    private com.example.onemore.models.mediator mediator;

}
