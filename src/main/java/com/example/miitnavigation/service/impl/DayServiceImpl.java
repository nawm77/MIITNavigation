//package com.example.miitnavigation.service.impl;
//
//import com.example.miitnavigation.repository.DayRepository;
//import com.example.miitnavigation.service.DayService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.concurrent.CompletableFuture;
//
//@Service
//public class DayServiceImpl implements DayService {
//    private final DayRepository dayRepository;
//
//    @Autowired
//    public DayServiceImpl(DayRepository dayRepository) {
//        this.dayRepository = dayRepository;
//    }
//
//    @Async
//    @Override
//    public CompletableFuture<Day> createDay(Day day) {
//        return CompletableFuture.completedFuture(dayRepository.save(day));
//    }
//
//    @Async
//    @Override
//    public CompletableFuture<Optional<Day>> getDayById(Long id) {
//        return CompletableFuture.completedFuture(dayRepository.findById(id));
//    }
//
//    @Async
//    @Override
//    public CompletableFuture<List<Day>> getAllDays() {
//        return CompletableFuture.completedFuture(dayRepository.findAll());
//    }
//
//    @Async
//    @Override
//    public CompletableFuture<Void> deleteDayById(Long id) {
//        dayRepository.deleteById(id);
//        return CompletableFuture.completedFuture(null);
//    }
//}
