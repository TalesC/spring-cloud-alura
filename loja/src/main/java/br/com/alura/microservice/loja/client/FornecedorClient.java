package br.com.alura.microservice.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alura.microservice.loja.controller.dto.ItemDaCompraDTO;
import br.com.alura.microservice.loja.service.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.service.dto.InfoPedidoDTO;


@FeignClient("fornecedor")
public interface FornecedorClient {

	@RequestMapping("/info/{estado}")
	InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

	@RequestMapping(method= RequestMethod.POST, path = "/pedido/")
	InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens);
	
}
