package com.market.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.productos.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer>{

}
