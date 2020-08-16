package br.com.sigo.monitorvendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MonitorVendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorVendasApplication.class, args);
	}


}