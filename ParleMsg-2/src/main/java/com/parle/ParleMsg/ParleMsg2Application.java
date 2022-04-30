package com.parle.ParleMsg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.parle.ParleMsg.REPOSITORY.InscriptionRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = InscriptionRepository.class)
public class ParleMsg2Application {

	public static void main(String[] args) {
		SpringApplication.run(ParleMsg2Application.class, args);
	}

}
