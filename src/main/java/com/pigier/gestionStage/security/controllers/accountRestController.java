package com.pigier.gestionStage.security.controllers;
import com.pigier.gestionStage.security.service.accountService;
import com.pigier.gestionStage.security.entities.appUser;
import com.pigier.gestionStage.security.entities.appRoles;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
@RestController
public class accountRestController {
    private final accountService accountService;

    public accountRestController(accountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping("/addRoles")
    public appRoles createRole(@RequestBody appRoles role){
        return accountService.addRoles(role);
    }
    @GetMapping("/listeUser")
    public List<appUser> listeUser(){
        return accountService.listUser();
    }
    @PostMapping("/addRoleToUser/{userId}/{roleId}")
    public void addRoleToUser(@PathVariable  Integer userId,@PathVariable Integer roleId){
        accountService.addRolesToUser(userId,roleId);
    }
    @GetMapping("/getuserbyUsername")
    public appUser getUserByUsername(String username){
        return accountService.loadUserByUsername(username);
    }
    @GetMapping("/getuserbyemail/{email}")
    public appUser getUserByEmail(@PathVariable String email){
        return accountService.loadUserByEmail(email);
    }
    @DeleteMapping("/delUser/{id}")
    public String delUserById(@PathVariable int id){
        return accountService.userDel(id);
    }
    @PostMapping("/profil")
    public appUser profil(Principal principal){
        return accountService.loadUserByEmail(principal.getName());
    }
}
