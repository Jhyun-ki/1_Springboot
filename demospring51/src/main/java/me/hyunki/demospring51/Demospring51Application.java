package me.hyunki.demospring51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class Demospring51Application {
    public static void main(String[] args) {
        SpringApplication.run(Demospring51Application.class, args);
    }
}