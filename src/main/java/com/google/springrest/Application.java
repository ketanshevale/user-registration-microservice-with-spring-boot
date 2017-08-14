package com.google.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories({"com.google.springrest.repository"})
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		//This will select application-prod.properties file
		//System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
		SpringApplication.run(Application.class, args);
	}
}