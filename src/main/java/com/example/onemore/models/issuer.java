package com.example.onemore.models;

import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "issuer")
public class issuer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idof_issuer")
    private Integer IDofIssuer;

    @Column(name = "type", columnDefinition = "varchar(40)")
    private String Type;

    @Column(name = "ogrn")
    private Integer ogrn;

}
