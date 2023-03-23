package com.example.miitnavigation.security;

import com.example.miitnavigation.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class RegistryController {
    private final RegistryService registryService;

    @Autowired
    public RegistryController(RegistryService registryService) {
        this.registryService = registryService;
    }
    @PostMapping("/new")
    public ResponseEntity<?> addNewUser(@RequestBody UserInfo userInfo){
        registryService.saveUser(userInfo);
        return ResponseEntity.ok("User saved");
    }

    @GetMapping("/miit/login")
    public String getLoginPage(){
        return "login";
    }

    @PostMapping("miit/login")
    public String successLogin(@RequestBody UserInfo userInfo){
        return "Success";
    }
}
