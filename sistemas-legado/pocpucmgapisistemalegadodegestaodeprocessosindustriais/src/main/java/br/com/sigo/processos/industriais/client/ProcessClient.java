package br.com.sigo.processos.industriais.client;

import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.consumingwebservice.wsdl.GetAllProcessesRequest;
import com.example.consumingwebservice.wsdl.GetAllProcessesResponse;

import com.example.consumingwebservice.wsdl.GetProcessRequest;
import com.example.consumingwebservice.wsdl.GetProcessResponse;


public class ProcessClient extends WebServiceGatewaySupport{
	
	
	public GetAllProcessesResponse getAllProcessesResponse(String a) {
		GetAllProcessesRequest request = new GetAllProcessesRequest();
		request.setName(a);
		
		GetAllProcessesResponse response = (GetAllProcessesResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:7171/ws/processes", request,
	            new SoapActionCallback(
	            		"http://spring.io/guides/gs-producing-web-service/GetAllProcessesRequest"));
	    return response;
	}
	
	public GetProcessResponse getProcessResponse(String process) {
		GetProcessRequest request = new GetProcessRequest();
		request.setName(process);
		
		
		GetProcessResponse response = (GetProcessResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:7171/ws/processes", request,
				new SoapActionCallback(
						"http://spring.io/guides/gs-producing-web-service/GetProcessRequest"));
		return response;
		
	}
	
	
	/*public GetCountryResponse getCountry(String country) {

    GetCountryRequest request = new GetCountryRequest();
    request.setName(country);

    log.info("Requesting location for " + country);

    GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
        .marshalSendAndReceive("http://localhost:8080/ws/countries", request,
            new SoapActionCallback(
                "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

    return response;
  }*/
	
}
