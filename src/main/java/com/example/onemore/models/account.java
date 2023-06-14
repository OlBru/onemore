package com.example.onemore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "account")
public class account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idof_account")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idof_holder", referencedColumnName ="idof_holder")
    @JsonBackReference
    private com.example.onemore.models.holder holder;


    @Column(name = "account_type",columnDefinition = "varchar(50)")
    private String type;

    @Column(name = "registration_number")
    private Integer registrationnumber;

    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
    private List<buysell> buysells;

}
