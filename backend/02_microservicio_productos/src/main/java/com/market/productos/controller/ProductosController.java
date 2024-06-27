package com.market.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.productos.model.Categoria;
import com.market.productos.model.Producto;
import com.market.productos.service.ProductosService;

@RestController
@CrossOrigin("*")
public class ProductosController {

	@Autowired
	ProductosService productoService;

	@GetMapping("categorias")
	public ResponseEntity<List<Categoria>> categorias() {
		return new ResponseEntity<>(productoService.categorias(), HttpStatus.OK);
	}

	@GetMapping("productos")
	public ResponseEntity<List<Producto>> productosCategorias(@RequestParam("idCategoria") int idCategoria) {
		return new ResponseEntity<>(productoService.productosPorCategoria(idCategoria), HttpStatus.OK);
	}

	@GetMapping("producto")
	public ResponseEntity<Producto> productoCodigo(@RequestParam("idProducto") int idProducto) {
		return new ResponseEntity<>(productoService.productoPorCodigo(idProducto), HttpStatus.OK);
	}

	@PutMapping("producto")
	public ResponseEntity<Void> actualizarStock(@RequestParam("idProducto") int idProducto,
			@RequestParam("unidades") int unidades) {
		Producto producto = productoService.actualizarStock(idProducto, unidades);
		if (producto != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
}
