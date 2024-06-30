package com.pigier.gestionStage.security.service;

import com.pigier.gestionStage.security.entities.appRoles;
import com.pigier.gestionStage.security.entities.appUser;

import java.util.List;

public interface accountService {
    //appUser addUser(appUser user);
    appUser updateUser(Integer id,Integer roleId,appUser user);
    appRoles addRoles(appRoles roles);
    void addRolesToUser(Integer userId, Integer roleId);
    appUser loadUserByUsername(String username);
    appUser loadUserByEmail(String email);
    List<appUser> listUser();
    String userDel(Integer id);

}
