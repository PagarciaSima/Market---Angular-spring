package com.market.clientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.clientes.dao.ClienteDao;
import com.market.clientes.model.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	ClienteDao clienteDao;
	
	@Override
	public Cliente autenticarCliente(String usuario, String password) {
		return clienteDao.findByUsuarioAndPassword(usuario, password);
	}

	@Override
	public boolean registrarCliente(Cliente cliente) {
		if (clienteDao.findById(cliente.getUsuario()).isPresent()) {
			return false;
		}
		clienteDao.save(cliente);
		return true;
	}

}
