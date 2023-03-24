package com.example.miitnavigation.Component;

import com.example.miitnavigation.model.UserInfo;
import com.example.miitnavigation.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private final UserInfoRepository repository;
    private final PasswordEncoder encoder;

    @Autowired
    public DataLoader(UserInfoRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        UserInfo user = new UserInfo();
        user.setPassword(encoder.encode("adminadmin"));
        user.setEmail("email@email.com");
        user.setRoles("ADMIN");
        user.setName("adminMIIT");
        repository.save(user);
    }
}
