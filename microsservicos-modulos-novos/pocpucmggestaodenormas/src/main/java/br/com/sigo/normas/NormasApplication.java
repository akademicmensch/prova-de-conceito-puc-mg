package br.com.sigo.normas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NormasApplication {

	public static void main(String[] args) {
		SpringApplication.run(NormasApplication.class, args);
	}

}
