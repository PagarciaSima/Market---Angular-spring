package com.market.clientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.clientes.model.Cliente;
import com.market.clientes.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/autenticar")
	public Cliente autenticar (@RequestParam ("usuario") String usuario,@RequestParam ("password") String password) {
		return clienteService.autenticarCliente(usuario, password);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Void> registrar(@RequestBody Cliente cliente) {
		if(clienteService.registrarCliente(cliente)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<> (HttpStatus.CONFLICT);
		}
	}
}
