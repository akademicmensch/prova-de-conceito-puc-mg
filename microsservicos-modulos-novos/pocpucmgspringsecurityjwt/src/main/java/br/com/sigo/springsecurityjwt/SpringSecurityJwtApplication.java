package br.com.sigo.springsecurityjwt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.sigo.springsecurityjwt.models.SampleUser;
import br.com.sigo.springsecurityjwt.services.MyUserDetailsService;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner sampleData(MyUserDetailsService userService) {
		return (args) -> {
			userService.inputDefaultUsers(new SampleUser("admin","admin"));
			userService.inputDefaultUsers(new SampleUser("guilherme.batista","admin"));
			userService.inputDefaultUsers(new SampleUser("consultoria.um","consultoria"));
			userService.inputDefaultUsers(new SampleUser("consultoria.dois","consultoria"));
			userService.inputDefaultUsers(new SampleUser("funcionario.generico","funcionario"));
		};
	}
}
