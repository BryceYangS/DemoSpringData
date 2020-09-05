package me.whiteship.demospringdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(HosukRegistrar.class)
public class DemospringdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemospringdataApplication.class, args);
	}

}
