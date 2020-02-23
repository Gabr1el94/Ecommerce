package com.gabrielsoaresdev.ecommerce.Ecommerce.repository;

import java.util.List;

import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Produto;

public interface ProdutoDao {

	public List<Produto> produtos();
	
	public Long registrarProduto(Produto produto);

	public Produto buscarProdutoByID(Long idProduto);
	
}
