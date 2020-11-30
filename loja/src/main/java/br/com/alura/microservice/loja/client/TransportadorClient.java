package br.com.alura.microservice.loja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alura.microservice.loja.controller.dto.VoucherDTO;
import br.com.alura.microservice.loja.service.dto.InfoEntregaDTO;

@FeignClient("transportador")
public interface TransportadorClient {

	@RequestMapping(method = RequestMethod.POST, path = "/entrega")
	VoucherDTO reservaEntrega(InfoEntregaDTO entregaDTO);
	
}
