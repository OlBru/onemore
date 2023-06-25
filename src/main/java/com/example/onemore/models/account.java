package com.example.onemore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "account")
public class account {
    @Id
    @Column(name = "idof_account")
    public Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idof_holder", referencedColumnName = "idof_holder")
    @JsonBackReference
    private holder holder;


    @Column(name = "account_type", columnDefinition = "varchar(50)")
    private String type;

    @Column(name = "registration_number")
    private Integer registrationnumber;

    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
    private List<buysell> buysells;
}



