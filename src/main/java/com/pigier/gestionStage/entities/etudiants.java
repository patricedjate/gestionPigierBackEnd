package com.pigier.gestionStage.entities;

import com.pigier.gestionStage.security.entities.appUser;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
public class etudiants {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String universite;
    private String niveau_etude;
    private String date_naissance;
    @OneToMany
    private Collection<stages> stage = new ArrayList<>();
    @OneToOne
    private appUser user = new appUser();
}
