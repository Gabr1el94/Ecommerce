package com.gabrielsoaresdev.ecommerce.Ecommerce.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "ecommercecr")
public class Carrinho implements Serializable {
	
	private static final long serialVersionUID = -2609445365200642674L;

	@Id
	@Column(name = "ecommercecr00", unique = true, nullable = false)
	private Long idCarrinho;
	
	@Column(name = "ecommercecr01", nullable = false, precision = 12,scale = 2)
	private BigDecimal subtotal;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
	@Cascade(CascadeType.SAVE_UPDATE)
	@Column(name = "ecommercecr02")
	private List<Item> items = new ArrayList<Item>();

	public Carrinho() {
	}

	public Carrinho(Long idCart, BigDecimal subtotal) {
		this.idCarrinho = idCart;
		this.subtotal = subtotal;
	}

	public Carrinho(Long idCart, BigDecimal subtotal, List<Item> linesItems) {
		this.idCarrinho = idCart;
		this.subtotal = subtotal;
		this.items = linesItems;
	}

	public Long getIdCarrinho() {
		return this.idCarrinho;
	}

	void setIdCarrinho(Long idCart) {
		this.idCarrinho = idCart;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public List<Item> getItems() {
		return this.items;
	}

	void setItems(List<Item> items) {
		this.items = items;
	}
	
	public BigDecimal calculateTotal(){
		BigDecimal total = BigDecimal.ZERO;
		for (Item item : this.getItems()) {
			total.add(item.getPreco().multiply(new BigDecimal(item.getQuantidade())));		
		}
		return total;
	}
}
