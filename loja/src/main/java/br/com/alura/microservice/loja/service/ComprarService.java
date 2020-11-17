package br.com.alura.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

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
	
	@HystrixCommand(fallbackMethod = "realizaCompraFallback")
	public Compra realizaCompra(CompraDTO compra) {
		
		final String estado =  compra.getEndereco().toString();
		
		LOG.info("buscando informação do fornecedor de {}", estado);
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
		LOG.info("realizando um  pedido", estado);
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Compra(pedido.getId(), pedido.getTempoDePreparo(), info.getEndereco());
		
	}
	
	public Compra realizaCompraFallback(CompraDTO compra) {
		return new Compra(null, null, compra.getEndereco().toString());
	}

}
