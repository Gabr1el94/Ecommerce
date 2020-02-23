package com.gabrielsoaresdev.ecommerce.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoController produtoController;
	
	@RequestMapping(value = "/produtos",method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<?> buscarProdutos(){
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Error durante a consulta no banco",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "/produto/",method = RequestMethod.POST)
	public ResponseEntity<?> registroProduto(){
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Error durante a registrar o produto",HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
