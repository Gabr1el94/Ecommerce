package com.gabrielsoaresdev.ecommerce.Ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Cupom;
import com.gabrielsoaresdev.ecommerce.Ecommerce.service.interfaces.ICupom;

@Service
@Transactional
public class CupomService implements ICupom{

	@Override
	public List<Cupom> cupons() {
		return null;
	}

	@Override
	public boolean registrarCupom() {
		return false;
	}
	
	

}
