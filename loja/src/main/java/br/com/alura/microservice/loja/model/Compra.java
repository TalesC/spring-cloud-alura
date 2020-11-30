package br.com.alura.microservice.loja.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long pedidoId;
	
	private Integer tempoDePreparo;
	
	private String enderecoDestino;
	
	private LocalDate dataParaEntrega;
	
	private Long voucher;
	
	@Enumerated(EnumType.STRING)
	private CompraState state;
	
	public Compra() {
		super();
	}

	public Long getPedidoId() {
		return pedidoId;
	}
	
	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}
	
	public String getEnderecoDestino() {
		return enderecoDestino;
	}

	public LocalDate getDataParaEntrega() {
		return dataParaEntrega;
	}

	public Long getVoucher() {
		return voucher;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public void setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}

	public void setDataParaEntrega(LocalDate dataParaEntrega) {
		this.dataParaEntrega = dataParaEntrega;
	}

	public void setVoucher(Long voucher) {
		this.voucher = voucher;
	}

	public CompraState getState() {
		return state;
	}

	public void setState(CompraState state) {
		this.state = state;
	}
	
}
