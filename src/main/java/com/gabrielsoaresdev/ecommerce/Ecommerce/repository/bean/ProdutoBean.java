package com.gabrielsoaresdev.ecommerce.Ecommerce.repository.bean;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Produto;
import com.gabrielsoaresdev.ecommerce.Ecommerce.repository.ProdutoDao;

@Repository
public class ProdutoBean implements ProdutoDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
	    return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> produtos() {
		String queryString = "SELECT p FROM Produto AS p";
		List<Produto> resultProdutos = getSession().createQuery(queryString).list();	
		if (resultProdutos.size()!=0 && resultProdutos!=null) {
			return resultProdutos;
		}
		return null;
	}

	@Override
	public Long registrarProduto(Produto produto) {
		return (Long) sessionFactory.getCurrentSession().save(produto);
	}

	@Override
	public Produto buscarProdutoByID(Long idProduto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
