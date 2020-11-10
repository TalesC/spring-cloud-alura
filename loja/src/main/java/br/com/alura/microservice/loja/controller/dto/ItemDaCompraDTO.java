package br.com.alura.microservice.loja.controller.dto;

public class ItemDaCompraDTO {
	
	private Long id;
	private int quanttidade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuanttidade() {
		return quanttidade;
	}
	public void setQuanttidade(int quanttidade) {
		this.quanttidade = quanttidade;
	}
}
