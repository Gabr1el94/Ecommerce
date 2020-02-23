package com.gabrielsoaresdev.ecommerce.Ecommerce.service.interfaces;

import java.util.List;

import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Produto;

public interface IProduto {
	
	public List<Produto> produtos();
	
	public boolean registrarProduto(Produto produto);

}
