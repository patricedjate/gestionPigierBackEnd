package com.pigier.gestionStage.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
public class applications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String date_application;
    private String Statut;
    @OneToMany
    private Collection<etudiants> etudiant = new ArrayList<>();
    @OneToMany
    private Collection<stages> stage = new ArrayList<>();
}
