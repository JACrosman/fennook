package com.fennook.fennookmono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class FennookMonoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FennookMonoApplication.class, args);
	}

}
