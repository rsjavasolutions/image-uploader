package com.rsjava.imageuploader.security;

import com.rsjava.imageuploader.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    private UserDetailServiceImpl userDetailService;

    @Autowired
    public WebSecurityConfig(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }

    //szyfrowanie haseł użytkowników
    @Bean
    public PasswordEncoder passwordEncoder() {
        //obiekt odpowiedzialny za szyfrowanie
        return new BCryptPasswordEncoder();
    }

    //konfiguruję użytkowników
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);

        //        auth.inMemoryAuthentication()
//                .withUser("jan")
//                .password(passwordEncoder().encode("jan123"))
//                .roles("user");
    }

    //konfiguruję endpointy
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //tylko zalogowani użytkownicy "authenticated()" mają dostęp do endpoint test1
                .antMatchers("/test1").authenticated()
                .antMatchers("/test2").hasRole("USER")
                .antMatchers("/test3").hasRole("ADMIN")
                .antMatchers("/test4").permitAll()
                .and()
                //do formatki logowania będą miały dostęp wszyscy
                .formLogin();
    }
}
