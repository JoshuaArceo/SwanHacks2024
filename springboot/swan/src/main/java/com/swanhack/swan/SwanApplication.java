package com.swanhack.swan;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.swanhack.swan")
public class SwanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwanApplication.class, args);
	}

}
