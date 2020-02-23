package com.gabrielsoaresdev.ecommerce.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gabrielsoaresdev.ecommerce.Ecommerce.entity.Produto;
import com.gabrielsoaresdev.ecommerce.Ecommerce.service.ProdutoService;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/produtos",method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<?> buscarProdutos(){
		try {
			List<Produto> produtos = produtoService.produtos();
			if (produtos.size()!=0 && produtos!=null) {
				return new ResponseEntity<List<Produto>>(produtos,HttpStatus.OK);
			}else {
				   return new ResponseEntity<String>("Não existe produtos no banco de dados",HttpStatus.NOT_FOUND);
			   }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Error durante a consulta no banco",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "/produto/",method = RequestMethod.POST)
	public ResponseEntity<?> registrarProduto(@RequestBody Produto produto){
		try {
			boolean check = produtoService.registrarProduto(produto);
			if (check) {
				return new ResponseEntity<String>("Produto registrado com sucesso",HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Error durante a registrar o produto",HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
