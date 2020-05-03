package com.rsjava.imageuploader.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //szyfrowanie haseł użytkowników
    @Bean
    public PasswordEncoder passwordEncoder(){
        //obiekt odpowiedzialny za szyfrowanie
        return new BCryptPasswordEncoder();
    }

    //konfiguruję użytkowników
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("jan")
                .password(passwordEncoder().encode("jan123"))
                .roles("user");
    }

    //konfiguruję endpointy
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //tylko zalogowani użytkownicy "authenticated()" mają dostęp do endpoint test1
                .antMatchers("/test1").authenticated()
                .and()
                //do formatki logowania będą miały dostęp wszyscy
                .formLogin();
    }
}
