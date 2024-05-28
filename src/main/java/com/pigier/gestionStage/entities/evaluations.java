package com.pigier.gestionStage.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
@Data
@Entity
public class evaluations
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String date_evaluation;
    private String commentaire;
    private Integer note;
    @OneToMany
    private Collection<applications> application = new ArrayList<>();
}
