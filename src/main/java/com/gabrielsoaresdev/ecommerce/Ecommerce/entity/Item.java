package com.gabrielsoaresdev.ecommerce.Ecommerce.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ecommerceit")
public class Item implements Serializable {
	
	private static final long serialVersionUID = -2026009079929881719L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ecommerceit00", unique = true, nullable = false)
	private Long idItem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ecommerceit01", nullable = false)
	private Carrinho carrinho;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ecommerceit02", nullable = false)
	private Produto produto;

	@Column(name = "ecommerceit03", nullable = false)
	private Integer quantidade;
	
	@Column(name = "ecommerceit04", nullable = false, precision = 12,scale = 2)
	private BigDecimal preco;

	public Item() {
	}

	public Item(Carrinho cart, Produto product, Integer quantity, BigDecimal price) {
		this.carrinho = cart;
		this.produto = product;
		this.quantidade = quantity;
		this.preco = price;
	}

	public Long getIdlinesItem() {
		return this.idItem;
	}

	public void setIdlinesItem(Long idlinesItem) {
		this.idItem = idlinesItem;
	}

	public Carrinho getCarinho() {
		return this.carrinho;
	}

	public void setCarinho(Carrinho cart) {
		this.carrinho = cart;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto product) {
		this.produto = product;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantity) {
		this.quantidade = quantity;
	}

	public BigDecimal getPreco() {
		return this.preco;
	}

	public void setPreco(BigDecimal price) {
		this.preco = price;
	}

}
