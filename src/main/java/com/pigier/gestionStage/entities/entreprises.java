package com.pigier.gestionStage.entities;

import com.pigier.gestionStage.security.entities.appUser;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
public class entreprises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String adresse;
    private String email;
    private String telephone;
    private String secteur_activite;
    @OneToMany
    private Collection<stages> stage = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    private appUser user = new appUser();

}
