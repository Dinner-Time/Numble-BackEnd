package com.numble.carrotmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CarrotmarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrotmarketApplication.class, args);
	}

}
