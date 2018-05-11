package br.com.bookmark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LeitorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeitorServiceApplication.class, args);
	}
}
