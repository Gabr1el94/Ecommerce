package com.gabrielsoaresdev.ecommerce.Ecommerce.repository.bean;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Cupom;
import com.gabrielsoaresdev.ecommerce.Ecommerce.repository.CupomDao;

@Repository
public class CupomBean implements CupomDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
	    return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cupom> cupons() {
		String queryString = "SELECT c FROM Cupom AS c";
		List<Cupom> resultCupons = getSession().createQuery(queryString).list();	
		
		if (resultCupons.size()!=0 && resultCupons!=null) {
			return resultCupons;
		}
		
		return null;
	}

	@Override
	public Long registrarCupom(Cupom cupom) {
		return (Long) sessionFactory.getCurrentSession().save(cupom);
	}
	
	@Override
	public Cupom buscarCupomByID(Long idCupom) {
		String queryString = "FROM Cupom WHERE idCarrinho = :idCarrinho";
		Cupom resultCupom = (Cupom) sessionFactory.getCurrentSession().createQuery(queryString)
		.setParameter("idCarrinho", idCupom).uniqueResult();
		
		if (resultCupom!=null) {
			return resultCupom;
		}
		
		return null;
	}
	

}
