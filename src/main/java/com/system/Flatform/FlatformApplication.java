package com.system.Flatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlatformApplication.class, args);
	}

}
