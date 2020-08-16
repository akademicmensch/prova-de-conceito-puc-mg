package br.com.sigo.consultorias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsultoriasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultoriasApplication.class, args);
	}

}
