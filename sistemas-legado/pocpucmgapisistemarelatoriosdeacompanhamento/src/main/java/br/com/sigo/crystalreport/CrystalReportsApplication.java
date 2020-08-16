package br.com.sigo.crystalreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CrystalReportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrystalReportsApplication.class, args);
	}
}