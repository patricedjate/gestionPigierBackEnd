package com.pigier.gestionStage.security.repositories;

import com.pigier.gestionStage.security.entities.appUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface appUserRepository extends JpaRepository<appUser,Integer> {
    appUser findByUsername(String username);
    appUser findByEmail(String email);
}
