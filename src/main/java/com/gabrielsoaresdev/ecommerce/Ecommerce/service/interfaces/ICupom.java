package com.gabrielsoaresdev.ecommerce.Ecommerce.service.interfaces;

import java.util.List;

import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Cupom;

public interface ICupom {

	public List<Cupom> cupons();
	
	public boolean registrarCupom();
	
}
