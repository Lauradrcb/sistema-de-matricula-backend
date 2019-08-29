package br.com.tcclaura.appsistemamatricula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "br.com.tcclaura.appsistemamatricula.repository")
@SpringBootApplication
public class AppsistemamatriculaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppsistemamatriculaApplication.class, args);
	}
}
