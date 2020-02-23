package com.gabrielsoaresdev.ecommerce.Ecommerce.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Carrinho;
import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Item;
import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Produto;
import com.gabrielsoaresdev.ecommerce.Ecommerce.repository.CarrinhoDao;
import com.gabrielsoaresdev.ecommerce.Ecommerce.repository.CupomDao;
import com.gabrielsoaresdev.ecommerce.Ecommerce.repository.ProdutoDao;
import com.gabrielsoaresdev.ecommerce.Ecommerce.service.interfaces.ICarrinho;

@Service
@Transactional
public class CarrinhoService implements ICarrinho{

	private ProdutoDao produtoDao;
	
	private CarrinhoDao carrinhoDao;
	
	private CupomDao cupomDao;
	
	@Autowired
	public CarrinhoService(ProdutoDao produtoDao, CarrinhoDao carrinhoDao,CupomDao cupomDao) {
		this.produtoDao = produtoDao;
		this.carrinhoDao = carrinhoDao;
		this.cupomDao=cupomDao;
	}

	@Override
	public boolean registrarCarrinho(Carrinho carrinho) {
		if (validacao(carrinho)) {
			Long id = carrinhoDao.salvarCarrinho(carrinho);
			if (id!=null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addProdutoCarrinho(Long idCarrinho, Long idProduto, Integer quantity) {
			Carrinho buscaCarrinho = carrinhoDao.buscarCarrinhoByID(idCarrinho);
			Produto buscaProduto = produtoDao.buscarProdutoByID(idProduto);
			if (validacaoCarrinhoProduto(buscaCarrinho,buscaProduto,quantity)) {
				buscaCarrinho.getItems().add(new Item(buscaCarrinho, buscaProduto, quantity,buscaProduto.getPrice()));
				buscaCarrinho.setSubtotal(buscaCarrinho.calculateTotal());
				carrinhoDao.adicionarProdutoCarrinho(buscaCarrinho);
				return true;
			}
			return false;
	}
	
	private boolean validacaoCarrinhoProduto(Carrinho cart, Produto produto,Integer qtd) {
		
		if (cart==null) {
			System.err.println("O carrinho não foi encontrado");
			return false;
		}
		
		if (produto==null) {
			System.err.println("O produto não foi encontrado");
			return false;
		}
		
		if (qtd<=0 && qtd.equals(null)) {
			System.err.println("A quantidade do produto não pode ser menor ou igual a zero!");
			return false;
		}
		
		return true;
	}

	private boolean validacao(Carrinho carrinho) {
		if (carrinho.getIdCarrinho().equals(null) || carrinho.getIdCarrinho().equals("") || carrinho.getIdCarrinho()<=0) {
			System.err.println("O carrinho não ser vázio, menor ou igual a zero");
			return false;
		}
		return true;
	}

}
