package com.pigier.gestionStage.security.service;

import com.pigier.gestionStage.security.entities.appUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
@Service
public class userDetailServiceImpl implements UserDetailsService {
    private final accountService accountService;
    public userDetailServiceImpl(accountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        appUser appUser = accountService.loadUserByEmail(email);
        Collection<GrantedAuthority> roles = new ArrayList<>();
        appUser.getRoles().forEach(
                r -> roles.add(new SimpleGrantedAuthority(r.getRoleName()))
        );
        return new User(appUser.getEmail(), appUser.getPassword(), roles);
    }
}
