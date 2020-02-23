package com.gabrielsoaresdev.ecommerce.Ecommerce.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ecommercecp")
public class Cupom implements Serializable{

	private static final long serialVersionUID = -4048623406823677438L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ecommercecp00")
	private Long idCupom;
	
	@Column(name = "ecommercecp01",nullable = false,length = 100)
	private String descricao;
	
	@Column(name = "ecommercecp02",nullable = false)
	private Integer quantidade;
	
	@Column(name = "ecommercecp03",nullable = false,precision = 5,scale = 4)
	private BigDecimal valor;
	
	@Column(name = "ecommercecp04",nullable = false)
	private LocalDateTime dtValidade;

	public Long getIdCupom() {
		return idCupom;
	}

	public String getDescricao() {
		return descricao;
	}

	void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDateTime getDtValidade() {
		return dtValidade;
	}

	void setDtValidade(LocalDateTime dtValidade) {
		this.dtValidade = dtValidade;
	}
	
	

}
