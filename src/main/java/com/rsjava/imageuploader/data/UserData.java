package com.rsjava.imageuploader.data;

import com.rsjava.imageuploader.model.AppUser;
import com.rsjava.imageuploader.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserData implements CommandLineRunner {

    private AppUserRepository appUserRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public UserData(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        AppUser admin = new AppUser("admin", passwordEncoder.encode("admin123"), "ROLE_ADMIN");
        AppUser user = new AppUser("user", passwordEncoder.encode("user123"), "ROLE_USER");

        appUserRepository.save(admin);
        appUserRepository.save(user);
    }
}
