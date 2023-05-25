//package com.example.miitnavigation.controller;
//
//import com.example.miitnavigation.exception.AuditoriumException;
//import com.example.miitnavigation.exception.ResourceNotFoundException;
//import com.example.miitnavigation.model.Auditorium;
//import com.example.miitnavigation.service.AuditoriumService;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.concurrent.ExecutionException;
//
//@Log4j2
//@RestController
//@RequestMapping("${api.base-path}")
//public class AuditoriumController {
//    private final AuditoriumService auditoriumService;
//
//    @Autowired
//    public AuditoriumController(AuditoriumService auditoriumService) {
//        this.auditoriumService = auditoriumService;
//    }
//
//    @GetMapping("/auditoriums")
//    @ResponseBody
//    public String getAllAuditorium() {
//        try {
//            var auditoriumById = auditoriumService.getAllAudiences();
//            log.info(auditoriumById);
//            List<Auditorium> auditoriums = auditoriumById.get();
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            return gson.toJson(auditoriums);
//        } catch (InterruptedException | ExecutionException e) {
//            throw new AuditoriumException("Ошибка при получении списка аудиторий");
//        }
//    }
//
//    @GetMapping("/auditorium/{id}")
//    @ResponseBody
//    public String getAuditoriumById(@PathVariable long id) throws ExecutionException, InterruptedException {
//        var auditoriumById = auditoriumService.getAuditoriumById(id);
//        log.info(auditoriumById);
//        Optional<Auditorium> auditorium = auditoriumById.get();
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        if (auditorium.isPresent()) {
//            return gson.toJson(auditorium.get());
//        } else {
//            throw new ResourceNotFoundException("Auditorium not found");
//        }
//    }
//}
