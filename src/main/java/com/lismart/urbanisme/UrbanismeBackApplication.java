package com.lismart.urbanisme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan("com.*")
@EnableJpaRepositories("com.*")
@EnableBatchProcessing()
public class UrbanismeBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrbanismeBackApplication.class, args);
	}

}
