package com.gabrielsoaresdev.ecommerce.Ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Produto;
import com.gabrielsoaresdev.ecommerce.Ecommerce.repository.bean.ProdutoBean;
import com.gabrielsoaresdev.ecommerce.Ecommerce.service.interfaces.IProduto;

@Service
@Transactional
public class ProdutoService implements IProduto{

	@Autowired
	private ProdutoBean produtoBean;
	
	@Override
	public List<Produto> produtos() {
		return produtoBean.produtos();
	}

	@Override
	public boolean registrarProduto(Produto produto) {
		if (validacao(produto)) {
			Long id = produtoBean.registrarProduto(produto);
			if (id!=null) {
				return true;
			}
		}
		return false;
	}
	
	private boolean validacao(Produto produto) {
		
		if (produto==null) {
			System.err.println("O produto não pode ser nulo");
			return false;
		}
		
		if (produto.getDescricao().equals("") || produto.getDescricao().equals(null)) {
			System.err.println("A descrição do produto deve ser preenchido");
			return false;
		}
		
		if (produto.getPrice().equals("") || produto.getPrice().equals(null)) {
			System.err.println("O valor do produto deve ser preenchido");
			return false;
		}else if(produto.getPrice().doubleValue()<=0) {
			System.err.println("O valor do produto não pode preencher menor ou igual do que zero");
			return false;
		}
		
		return true;
	}

}
