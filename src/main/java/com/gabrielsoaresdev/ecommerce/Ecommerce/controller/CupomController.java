package com.gabrielsoaresdev.ecommerce.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Cupom;
import com.gabrielsoaresdev.ecommerce.Ecommerce.service.CupomService;

@Controller
public class CupomController {
	
	@Autowired
	private CupomService cupomService;
	
	@RequestMapping(value = "/cupons",method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<?> buscarCupons(){
		try {
		   List<Cupom> cupons = cupomService.cupons();
		   
		   if (cupons.size()!=0 && cupons!=null) {
			   return new ResponseEntity<List<Cupom>>(cupons,HttpStatus.OK);
		   }else {
			   return new ResponseEntity<String>("Não existe cupons no banco de dados",HttpStatus.NOT_FOUND);
		   }
		   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Error durante a consulta no banco",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "/cupom/",method = RequestMethod.POST)
	public ResponseEntity<?> registrarCupom(@RequestBody Cupom cupom){
		try {
			boolean check = cupomService.registrarCupom(cupom);
			if (check) {
				return new ResponseEntity<String>("Cupom registrado com sucesso",HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Error durante a registrar o cupom",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
