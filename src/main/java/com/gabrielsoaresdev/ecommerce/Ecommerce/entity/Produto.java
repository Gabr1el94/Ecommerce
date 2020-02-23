package com.gabrielsoaresdev.ecommerce.Ecommerce.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ecommercepd", catalog = "shopping_cart_db")
public class Produto implements Serializable {

	private static final long serialVersionUID = -4567702652678783981L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ecommercepd00", unique = true, nullable = false)
	private Long idProduto;

	@Column(name = "ecommercepd01", nullable = false, length = 100)
	private String description;

	@Column(name = "ecommercepd02", nullable = false, precision = 12,scale = 2)
	private BigDecimal price;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	private List<Item> linesItems = new ArrayList<Item>();

	public Produto() {
	}

	public Produto(String description, BigDecimal price) {
		this.description = description;
		this.price = price;
	}

	public Produto(String description, BigDecimal price, List<Item> linesItems) {
		this.description = description;
		this.price = price;
		this.linesItems = linesItems;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Item> getLinesItems() {
		return this.linesItems;
	}

	public void setLinesItems(List<Item> linesItems) {
		this.linesItems = linesItems;
	}

}
