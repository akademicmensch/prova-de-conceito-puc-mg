package br.com.sap.processos.industriais.endpoints;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.sap.processos.industriais.repositories.ProcessRepository;
import io.spring.guides.gs_producing_web_service.GetAllProcessesRequest;
import io.spring.guides.gs_producing_web_service.GetProcessResponse;

import io.spring.guides.gs_producing_web_service.GetProcessResponse;
import io.spring.guides.gs_producing_web_service.GetProcessRequest;
import io.spring.guides.gs_producing_web_service.GetAllProcessesResponse;
import io.spring.guides.gs_producing_web_service.GetAllProcessesRequest;
import io.spring.guides.gs_producing_web_service.Process;


@Endpoint
public class Endpoints {
	
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private ProcessRepository processRepository;

	@Autowired
	public Endpoints(ProcessRepository processRepository) {
		this.processRepository = processRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProcessRequest")
	@ResponsePayload
	public GetProcessResponse getprocess(@RequestPayload GetProcessRequest request) {
		GetProcessResponse response = new GetProcessResponse();
		Process findProcess = processRepository.findProcess(request.getName());
		response.setProcess(findProcess);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProcessesRequest")
	@ResponsePayload
	public GetAllProcessesResponse getAllProcesses(@RequestPayload GetAllProcessesRequest request) {
		GetAllProcessesResponse response = new GetAllProcessesResponse();

		List<Process> findAllProcessess = processRepository.findAllProcessess();
		for (Process process : findAllProcessess) {
			io.spring.guides.gs_producing_web_service.GetAllProcessesResponse.Process p = new io.spring.guides.gs_producing_web_service.GetAllProcessesResponse.Process();
			p.setProcess(process);
			response.getProcess().add(p);
		}
		
		
		
		return response;
	}

}
