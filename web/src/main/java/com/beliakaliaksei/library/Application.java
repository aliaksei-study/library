package com.beliakaliaksei.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.beliakaliaksei.library.encryption", "com.beliakaliaksei.library.service", "com.beliakaliaksei.library"})
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"com.beliakaliaksei.library.repository"})
@EntityScan(basePackages = {"com.beliakaliaksei.library.entity"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
