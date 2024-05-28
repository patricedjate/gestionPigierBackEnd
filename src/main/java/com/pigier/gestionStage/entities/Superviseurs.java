package com.pigier.gestionStage.entities;

import com.pigier.gestionStage.security.entities.appUser;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
public class Superviseurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    @OneToMany
    private Collection<entreprises> entreprise = new ArrayList<>();
    @OneToOne
    private appUser user = new appUser();

}
