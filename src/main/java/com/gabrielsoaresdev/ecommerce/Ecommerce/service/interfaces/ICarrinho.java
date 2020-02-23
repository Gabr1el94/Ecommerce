package com.gabrielsoaresdev.ecommerce.Ecommerce.service.interfaces;



import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Carrinho;

public interface ICarrinho {
	
	boolean registrarCarrinho(Carrinho cart);
	boolean addProdutoCarrinho(Long idCarrinho, Long idProduto, Integer quantity);

}
