package com.pav.smartparkingsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class SmartParkingSystemTest {

    @Test
    void contextLoads() {
        ApplicationModules modules = ApplicationModules.of(SmartParkingSystem.class)
                .verify();
        new Documenter(modules).writeDocumentation();
    }
}