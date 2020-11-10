package br.com.alura.microservice.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.model.Compra;
import br.com.alura.microservice.loja.service.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.service.dto.InfoPedidoDTO;

@Service
public class ComprarService {
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
	public Compra realizaCompra(CompraDTO compra) {
		List<InfoFornecedorDTO> info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		
		return new Compra(pedido.getId(), pedido.getTempoDePreparo(), compra.getEndereco().toString());
		
	}

}
