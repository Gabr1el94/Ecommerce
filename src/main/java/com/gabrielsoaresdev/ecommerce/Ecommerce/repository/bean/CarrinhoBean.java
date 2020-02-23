package com.gabrielsoaresdev.ecommerce.Ecommerce.repository.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Carrinho;
import com.gabrielsoaresdev.ecommerce.Ecommerce.repository.CarrinhoDao;

@Repository
public class CarrinhoBean implements CarrinhoDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
	    return sessionFactory.getCurrentSession();
	}

	@Override
	public Long salvarCarrinho(Carrinho carrinho) {
		return (Long) sessionFactory.getCurrentSession().save(carrinho);
	}

	@Override
	public void adicionarProdutoCarrinho(Carrinho carrinho) {
		sessionFactory.getCurrentSession().update(carrinho);
	}

	@Override
	public Carrinho buscarCarrinhoByID(Long idCarrinho) {
		String queryString = "FROM Carrinho WHERE idCarrinho = :idCarrinho";
		Carrinho resultCarrinho = (Carrinho) sessionFactory.getCurrentSession()
		.createQuery(queryString)
		.setParameter("idCarrinho", idCarrinho)
		.uniqueResult();
		
		if (resultCarrinho!=null) {
			return resultCarrinho;
		}
		
		return null;
	}

}
