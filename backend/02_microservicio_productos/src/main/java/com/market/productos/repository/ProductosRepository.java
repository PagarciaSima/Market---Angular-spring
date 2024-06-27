package com.market.productos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.productos.model.Producto;

public interface ProductosRepository extends JpaRepository<Producto, Integer> {

	List<Producto> findByIdCategoria(int idCategoria);
}
