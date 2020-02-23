package com.gabrielsoaresdev.ecommerce.Ecommerce.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Cupom;
import com.gabrielsoaresdev.ecommerce.Ecommerce.repository.bean.CupomBean;
import com.gabrielsoaresdev.ecommerce.Ecommerce.service.interfaces.ICupom;

@Service
@Transactional
public class CupomService implements ICupom{

	@Autowired
	private CupomBean cupomBean;
	
	@Override
	public List<Cupom> cupons() {
		return cupomBean.cupons();
	}

	@Override
	public boolean registrarCupom(Cupom cupom) {
		if (validacao(cupom)) {
			Long id = cupomBean.registrarCupom(cupom);
			if (id!=null) {
				return true;
			}
		}
		return false;
	}
	
	private boolean validacao(Cupom cupom) {
		
		if (cupom==null) {
			System.err.println("O cupom não pode ser nulo");
			return false;
		}
		
		if (cupom.getDescricao().equals("") || cupom.getDescricao().equals(null)) {
			System.err.println("A descrição do cupom deve ser preenchido");
			return false;
		}
		
		if (cupom.getValor().equals("") || cupom.getValor().equals(null)) {
			System.err.println("O valor do cupom deve ser preenchido");
			return false;
		}else if(cupom.getValor().doubleValue()<=0) {
			System.err.println("O valor do cupom não pode preencher menor ou igual do que zero");
			return false;
		}
		
		if (cupom.getDtValidade().equals("") || cupom.getDtValidade().equals(null)) {
			System.err.println("A data validade do cupom deve ser preenchido");
			return false;
		}else if (cupom.getDtValidade().isBefore(LocalDateTime.now())) {
			System.err.println("A data validade do cupom não pode preencher a data anterior");
			return false;
		}
		
		return true;
	}

}
