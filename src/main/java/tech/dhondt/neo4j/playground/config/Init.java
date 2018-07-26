package tech.dhondt.neo4j.playground.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Init {
    public static void main(String[] args) {
        SpringApplication.run(Init.class, args);
        Client.main(new String[]{});
    }
}