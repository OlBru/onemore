package com.example.onemore.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
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
