package com.market.clientes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.clientes.model.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, String>{

	Cliente findByUsuarioAndPassword(String usuario, String password);
}
