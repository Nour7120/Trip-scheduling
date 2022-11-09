package com.example.rhelTest.admin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfiguration {

    @Bean
    CommandLineRunner commandLineRunner (AdminRepository adminRepository)
    {
        return args -> {
            Admin admin = new Admin(
                    "Admin",
                    "Admin"
            );
            adminRepository.save(admin);
        };
    }
}
