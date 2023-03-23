package com.example.miitnavigation.security;

import com.example.miitnavigation.model.UserInfo;
import com.example.miitnavigation.repository.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RegistryService {
    private final UserInfoRepository userInfoRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public RegistryService(UserInfoRepository userInfoRepository, PasswordEncoder encoder) {
        this.userInfoRepository = userInfoRepository;
        this.encoder = encoder;
    }

    public void saveUser(UserInfo userInfo){
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        log.info("Save user" + userInfo);
    }
}
