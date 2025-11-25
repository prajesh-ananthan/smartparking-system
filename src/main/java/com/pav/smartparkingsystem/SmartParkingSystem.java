package com.pav.smartparkingsystem;

import com.pav.smartparkingsystem.allocation.Slot;
import com.pav.smartparkingsystem.allocation.SlotRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SmartParkingSystem {

    static void main(String[] args) {
        SpringApplication.run(SmartParkingSystem.class, args);
    }

    @Bean
    CommandLineRunner initSlots(SlotRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Slot(null, "A1", true, null));
                repo.save(new Slot(null, "A2", true, null));
                repo.save(new Slot(null, "B1", true, null));
            }
        };
    }

}
