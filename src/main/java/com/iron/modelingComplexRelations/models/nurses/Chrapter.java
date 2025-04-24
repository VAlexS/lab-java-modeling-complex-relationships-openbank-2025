package com.iron.modelingComplexRelations.models.nurses;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chrapter")
public class Chrapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String district;


    @OneToOne
    @JoinColumn(name = "president_id")
    private Member president; // Relación uno a uno con el presidente

    @OneToMany(mappedBy = "chapter")
    private List<Member> members; // Relación uno a muchos con los miembros
}
