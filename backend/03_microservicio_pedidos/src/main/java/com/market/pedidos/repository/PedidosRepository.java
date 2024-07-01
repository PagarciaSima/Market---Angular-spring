package com.market.pedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.pedidos.model.Pedido;

public interface PedidosRepository extends JpaRepository<Pedido, Integer>{
	
	List<Pedido> findByUsuario(String usuario);
}
