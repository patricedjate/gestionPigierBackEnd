package com.pigier.gestionStage.security.service;

import com.pigier.gestionStage.security.entities.appRoles;
import com.pigier.gestionStage.security.entities.appUser;
import com.pigier.gestionStage.security.repositories.appRolesRepository;
import com.pigier.gestionStage.security.repositories.appUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.List;
@Service
@Transactional
public class accountServiceImpl implements accountService {
    private final appUserRepository appUserRepository;
    private final appRolesRepository appRolesRepository;

    private final PasswordEncoder passwordEncoder;
    public accountServiceImpl(appUserRepository appUserRepository, appRolesRepository appRolesRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRolesRepository = appRolesRepository;
        this.passwordEncoder = passwordEncoder;
    }
/*
    @Override
    public appUser addUser(appUser user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return appUserRepository.save(user);
    }
*/
    @Override
    public appUser updateUser(Integer id,Integer roleId, appUser user) {
        return appUserRepository.findById(id).map(p->{
                p.setEmail(p.getEmail());
                p.setUsername(p.getUsername());
                p.setPassword(passwordEncoder.encode(p.getPassword()));
                p.setRoles((Collection<appRoles>) appRolesRepository.findById(roleId).orElseThrow());
                return appUserRepository.save(p);
        }).orElseThrow();
    }

    @Override
    public appRoles addRoles(@RequestBody appRoles roles) {

        return appRolesRepository.save(roles);
    }

    @Override
    public void addRolesToUser(Integer userId, Integer roleId) {
        appUser User = appUserRepository.findById(userId).orElseThrow();
        appRoles Role = appRolesRepository.findById(roleId).orElseThrow();
        User.getRoles().add(Role);




    }

    @Override
    public appUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
    @Override
    public appUser loadUserByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }
    @Override
    public List<appUser> listUser() {
        return appUserRepository.findAll();
    }

    @Override
    public String userDel(Integer id) {
        appUserRepository.deleteById(id);
        return "Utilisateur supprimé avec succès";
    }
}
