package br.com.alura.microservice.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.service.dto.InfoFornecedorDTO;

@Service
public class ComprarService {
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
	public void realizaCompra(CompraDTO compra) {
		List<InfoFornecedorDTO> info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());		
		
		System.out.println(info.get(0).getEndereco());
	}

}
