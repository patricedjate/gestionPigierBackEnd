package com.pigier.gestionStage.security.repositories;

import com.pigier.gestionStage.security.entities.appRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface appRolesRepository extends JpaRepository<appRoles,Integer> {
    appRoles findByRoleName(String roleName);
}
