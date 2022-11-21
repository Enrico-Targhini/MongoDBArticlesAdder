package com.example.demo.config;

import com.example.demo.document.Author;
import com.example.demo.document.Users;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBConfig {


    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return strings -> {
            userRepository.save(new Users(1, "Peter", "Development", 3000L, new Author(6, "Sergio")));
            userRepository.save(new Users(2, "Sam", "Operations", 2000L, new Author(7, "Kevin")));
        };
    }
}