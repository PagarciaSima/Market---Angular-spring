package com.market.pedidos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "elementosPedido")
public class ElementosPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idElementoPedido;
	private int idPedidoFk;
	private int unidades;
	@ManyToOne()
	@JoinColumn(name = "idProductoFk", referencedColumnName = "idProducto")
	private Producto producto;
}
