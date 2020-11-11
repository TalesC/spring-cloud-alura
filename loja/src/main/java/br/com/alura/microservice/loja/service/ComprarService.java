package br.com.alura.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.model.Compra;
import br.com.alura.microservice.loja.service.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.service.dto.InfoPedidoDTO;

@Service
public class ComprarService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ComprarService.class);
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
	public Compra realizaCompra(CompraDTO compra) {
		
		final String estado =  compra.getEndereco().toString();
		
		LOG.info("buscando informação do fornecedor de {}", estado);
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
		LOG.info("realizando um  pedido", estado);
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		
		return new Compra(pedido.getId(), pedido.getTempoDePreparo(), info.getEndereco());
		
	}

}
