package com.market.clientes.service;

import com.market.clientes.model.Cliente;

public interface ClienteService {
	Cliente autenticarCliente(String usuario, String password);
	boolean registrarCliente(Cliente cliente);
}
