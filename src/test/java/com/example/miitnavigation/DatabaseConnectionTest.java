//package com.example.miitnavigation;
//
//import com.example.miitnavigation.model.UserInfo;
//import com.example.miitnavigation.repository.UserInfoRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mapstruct.control.MappingControl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class DatabaseConnectionTest {
//    private final UserInfoRepository repository;
//    private final PasswordEncoder encoder;
//
//    @Autowired
//    public DatabaseConnectionTest(UserInfoRepository repository, PasswordEncoder encoder) {
//        this.repository = repository;
//        this.encoder = encoder;
//    }
//
//    @Test
//    void checkAdminCredentials(){
//        UserInfo user = new UserInfo();
//        user.setName("adminMIIT");
//        List<UserInfo> userList = repository.findByName("adminMIIT").stream().collect(Collectors.toList());
//        UserInfo user2 = userList.get(0);
//        assertThat(user.getName()).isEqualTo(user2.getName());
//    }
//
//    @Test
//    void checkUsersCount(){
//        assertThat(repository.findAll().size()).isEqualTo(1);
//    }
//
//    @Test
//    void insertUserData(){
//        int count = repository.findAll().size();
//        UserInfo user = new UserInfo();
//        user.setEmail("rand");
//        user.setRoles("rand");
//        user.setName("rand");
//        repository.save(user);
//        Long id = repository.findByName(user.getName()).stream().collect(Collectors.toList()).get(0).getId();
//        assertThat(repository.findAll().size()).isEqualTo(++count);
//        repository.deleteById(id);
//    }
//}
