package com.pigier.gestionStage.security;

import com.pigier.gestionStage.security.filters.jwtAuthentificationFilter;
import com.pigier.gestionStage.security.filters.jwtAuthorizationFilter;
import com.pigier.gestionStage.security.service.userDetailServiceImpl;
import com.pigier.gestionStage.security.service.accountService;
import com.pigier.gestionStage.security.service.userDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final accountService accountService;

    private userDetailServiceImpl userDetailsService;

    AuthenticationManager authenticationManager;
    public SecurityConfig(accountService accountService, userDetailServiceImpl userDetailsService) {
        this.accountService = accountService;

        this.userDetailsService = userDetailsService;
    }


    @Autowired
    protected void globalConfig(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);

    }


    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService);
        authenticationManager = authenticationManagerBuilder.build();
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults());
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/login","/addUser","/etudiant/add","/etudiant/update/*","/addRoleToUser/*/*","/entreprise/add","/entreprise/liste")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .authenticationManager(authenticationManager);
        //http.formLogin(Customizer.withDefaults());
        http.sessionManagement((session) -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilter(new jwtAuthentificationFilter(authenticationManager));
        http.addFilterBefore(new jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
