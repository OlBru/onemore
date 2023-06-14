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
@Table(name = "papers")
public class papers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idof_papers")
    private Integer IDofPapers;

    @JoinColumn(name = "idof_issuer")
    private Integer IDofIssuer;

    @Column(name = "type", columnDefinition = "varchar(40)")
    private String Type;

    @Column(name = "nominal")
    private Integer Nominal;
    @Column(name = "releasedate")
    @Temporal(TemporalType.DATE)
    private java.sql.Date ReleaseDate;

    @Column(name = "Capital", columnDefinition = "varchar(15)")
    private String Capital;
    @Column(name = "IssueForm", columnDefinition = "varchar(30)")
    private String IssueForm;

    @Column(name = "IDofParent")
    private Integer IDofParent;
    @OneToMany(mappedBy = "papers")
    private List<buysell> buysells;

}