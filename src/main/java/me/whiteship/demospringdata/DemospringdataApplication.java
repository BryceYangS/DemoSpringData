package me.whiteship.demospringdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaRepositories(repositoryImplementationPostfix = "Default")
public class DemospringdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemospringdataApplication.class, args);
	}

}
