package com.gabrielsoaresdev.ecommerce.Ecommerce.repository;

import java.util.List;

import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Cupom;

public interface CupomDao {
	
	public List<Cupom> cupons();
	
	public Long registrarCupom(Cupom cupom);
	
	public Cupom buscarCupomByID(Long idCupom);
	
}
