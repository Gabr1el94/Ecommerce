package com.gabrielsoaresdev.ecommerce.Ecommerce.repository;

import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Carrinho;

public interface CarrinhoDao {
	
	public Long salvarCarrinho(Carrinho carrinho);
	public void adicionarProdutoCarrinho(Carrinho carrinho);
	public Carrinho buscarCarrinhoByID(Long idCarrinho);
}
