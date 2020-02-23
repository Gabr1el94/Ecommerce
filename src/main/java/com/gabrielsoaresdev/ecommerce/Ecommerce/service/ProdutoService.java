package com.gabrielsoaresdev.ecommerce.Ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Produto;
import com.gabrielsoaresdev.ecommerce.Ecommerce.service.interfaces.IProduto;

@Service
@Transactional
public class ProdutoService implements IProduto{

	@Override
	public List<Produto> produtos() {
		return null;
	}

	@Override
	public boolean registrarProduto() {
		return false;
	}

}
