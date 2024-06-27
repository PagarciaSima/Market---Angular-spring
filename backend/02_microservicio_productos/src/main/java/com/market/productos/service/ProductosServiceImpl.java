package com.market.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.productos.model.Categoria;
import com.market.productos.model.Producto;
import com.market.productos.repository.CategoriasRepository;
import com.market.productos.repository.ProductosRepository;

@Service
public class ProductosServiceImpl implements ProductosService{

	@Autowired
	CategoriasRepository categoriasRepository;
	
	@Autowired
	ProductosRepository productosRepository;
	
	@Override
	public List<Categoria> categorias() {
		return categoriasRepository.findAll();
	}

	@Override
	public List<Producto> productosPorCategoria(int idCategoria) {
		return productosRepository.findByIdCategoria(idCategoria);
	}

	@Override
	public Producto actualizarStock(int idProducto, int unidades) {
		Producto producto = productoPorCodigo(idProducto);
		if (producto != null && producto.getStock() >= unidades) {
			producto.setStock(unidades);
			return productosRepository.save(producto);
		}
		return null;
	}

	@Override
	public Producto productoPorCodigo(int idProducto) {
		return productosRepository.findById(idProducto).orElse(null);
	}

}
