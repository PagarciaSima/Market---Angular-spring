package com.market.pedidos.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.market.pedidos.model.ElementosPedido;
import com.market.pedidos.model.Pedido;
import com.market.pedidos.repository.ElementosPedidosRepository;
import com.market.pedidos.repository.PedidosRepository;

@Service
public class PedidosServiceImpl implements PedidosService{
	
	String urlProductos = "http://localhost:8082/";
	
//	@Autowired
//	RestTemplate restTemplate;
	@Autowired
	RestTemplate restClient;
	@Autowired
	PedidosRepository pedidosRepository;
	@Autowired
	ElementosPedidosRepository elementosPedidosRepository;
	
	@Override
	public List<Pedido> pedidosUsuario(String usuario) {
		return pedidosRepository.findByUsuario(usuario);
	}
	
	// Con Rest template
//	@Override
//	public Pedido guardarPedido(List<ElementosPedido> elementosPedido, String usuario) {
//		try {	
//			// Crear objeto pedido y guardarlo
//			Pedido pedido = new Pedido(0, usuario, new Date(), "pendiente", null);
//			Pedido pedidoGuardado = pedidosRepository.save(pedido);
//			
//			// Guardar elementos pedido (items)
//			elementosPedido.forEach(e -> {
//				e.setIdPedidoFk(pedidoGuardado.getIdPedido());
//				elementosPedidosRepository.save(e);
//				// Actualizar stock producto llamando al microservicio de productos
//				UriComponentsBuilder builder = 
//				UriComponentsBuilder.fromHttpUrl(urlProductos + "producto")
//					.queryParam("idProducto", e.getProducto().getIdProducto())
//					.queryParam("unidades", e.getUnidades());
//				restTemplate.put(builder.toUriString(), null);
//			});
//			return pedido;
//		} catch (Exception e) {
//			return null;
//		}
//		
//	}
	
	@Override
	public Pedido guardarPedido(List<ElementosPedido> elementosPedido, String usuario) {
		try {	
			// Crear objeto pedido y guardarlo
			Pedido pedido = new Pedido(0, usuario, new Date(), "pendiente", null);
			Pedido pedidoGuardado = pedidosRepository.save(pedido);
			
			// Guardar elementos pedido (items)
			elementosPedido.forEach(e -> {
				e.setIdPedidoFk(pedidoGuardado.getIdPedido());
				elementosPedidosRepository.save(e);
				// Actualizar stock producto llamando al microservicio de productos
				UriComponentsBuilder builder = 
				UriComponentsBuilder.fromHttpUrl(urlProductos + "producto")
					.queryParam("idProducto", e.getProducto().getIdProducto())
					.queryParam("unidades", e.getUnidades());
				restTemplate.put(builder.toUriString(), null);
			});
			return pedido;
		} catch (Exception e) {
			return null;
		}
		
	}

}
