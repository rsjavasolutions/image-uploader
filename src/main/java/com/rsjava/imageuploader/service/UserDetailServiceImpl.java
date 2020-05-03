package com.rsjava.imageuploader.service;

import com.rsjava.imageuploader.model.AppUser;
import com.rsjava.imageuploader.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//klasa która pośredniczy w wyciąganiu użytkowników z bazy danych na podstawie
//dostarczonego loginu
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private AppUserRepository appUserRepository;

    @Autowired
    public UserDetailServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return appUserRepository.findByUsername(s).get();
    }
}
