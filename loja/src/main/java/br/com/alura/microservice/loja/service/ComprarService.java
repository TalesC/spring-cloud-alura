package br.com.alura.microservice.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.service.dto.InfoFornecedorDTO;

@Service
public class ComprarService {
	
	@Autowired
	private RestTemplate client;
	
	@Autowired
	private DiscoveryClient eurekaClient;

	public void realizaCompra(CompraDTO compra) {
		ResponseEntity<List<InfoFornecedorDTO>> info = client.exchange("http://fornecedor/info/" + compra.getEndereco().getEstado(),
				HttpMethod.GET, null, new ParameterizedTypeReference<List<InfoFornecedorDTO>>(){});
		
		eurekaClient.getInstances("fornecedor").stream()
		.forEach( fornecedor -> {
			System.out.println("localhost:" + fornecedor.getPort());
		});
		
		System.out.println(info.getBody().get(0).getEndereco());
	}

}
