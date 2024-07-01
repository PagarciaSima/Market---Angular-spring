package com.market.pedidos.service;

import java.util.List;

import com.market.pedidos.model.ElementosPedido;
import com.market.pedidos.model.Pedido;

public interface PedidosService {
	
	List<Pedido> pedidosUsuario(String usuario);
	Pedido guardarPedido(List<ElementosPedido> elementosPedido, String usuario);
}
