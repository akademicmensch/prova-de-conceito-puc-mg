package br.com.sigo.processos.industriais.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import br.com.sigo.processos.industriais.client.ProcessClient;

@Configuration
public class ProcessoIndustrialConfiguration {
	
	@Bean
	  public Jaxb2Marshaller marshaller() {
	    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
	    marshaller.setContextPath("com.example.consumingwebservice.wsdl");
	    return marshaller;
	  }
	
	
	@Bean
	public ProcessClient processClient(Jaxb2Marshaller marshaller) {
		ProcessClient client = new ProcessClient();
		client.setDefaultUri("http://localhost:7171/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	
}
