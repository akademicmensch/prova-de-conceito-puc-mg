package br.com.sigo.processos.industriais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SistemaDeGestaoDeProcessosIndustriaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeGestaoDeProcessosIndustriaisApplication.class, args);
	}

}
