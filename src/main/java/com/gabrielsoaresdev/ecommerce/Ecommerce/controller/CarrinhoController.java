package com.gabrielsoaresdev.ecommerce.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Carrinho;
import com.gabrielsoaresdev.ecommerce.Ecommerce.service.CarrinhoService;

@Controller
public class CarrinhoController {

	@Autowired
	private CarrinhoService carrinhoService;
	
	@RequestMapping(value = "/carrinho/",method = RequestMethod.POST)
	public ResponseEntity<?> registrarCarrinho(@RequestBody Carrinho carrinho){
		try {
			boolean check = carrinhoService.registrarCarrinho(carrinho);
			if (check) {
				return new ResponseEntity<String>("Carrinho salvo com sucesso!",HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Ocorreu erro inesperado após registrar o carrinho",HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/carrinho/{idCarrinho}/{idProduto}/{quantidade}",method = RequestMethod.POST)
	public ResponseEntity<?> registrarProdutoCarrinho(@PathVariable("idCarrinho") Long idCarrinho,
			@PathVariable("idProduto") Long idProduto,@PathVariable("quantidade") Integer quantidade){
		try {
			boolean check = carrinhoService.addProdutoCarrinho(idCarrinho, idProduto, quantidade);
			if (check) {
				return new ResponseEntity<String>("Carrinho salvo com sucesso!",HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Ocorreu erro inesperado após registrar o carrinho",HttpStatus.NOT_FOUND);
	}
	
}
