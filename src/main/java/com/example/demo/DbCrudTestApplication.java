package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DbCrudTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbCrudTestApplication.class, args);
	}

        @Bean
        CommandLineRunner init(UserRepository repository) {
        return args -> {
            repository.save(new User("Jane"));
            repository.save(new User("William"));
            repository.save(new User("Marcus"));
            repository.save(new User("Xin"));
            repository.save(new User("Kristian"));
        };

    }
}
