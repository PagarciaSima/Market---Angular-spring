import { Component, OnInit } from '@angular/core';
import { Categoria } from 'src/app/model/Categoria';
import { Producto } from 'src/app/model/Producto';
import { ProcesarPedidoService } from '../../service/procesar-pedido.service';
import { CestaItem } from 'src/app/model/CestaItem';

@Component({
  selector: 'app-procesar-pedido',
  templateUrl: './procesar-pedido.component.html',
  styleUrls: ['./procesar-pedido.component.css'],
})
export class ProcesarPedidoComponent implements OnInit {
  categorias: Categoria[];
  productos: Producto[];
  idCategoriaSel: number;
  cesta: CestaItem[];

  constructor(private procesarPedidoService: ProcesarPedidoService) {}

  ngOnInit(): void {
    // Carga lista categorías
    this.procesarPedidoService
      .categorias()
      .subscribe((categorias) => (this.categorias = categorias));

    this.cesta = [];
  }

  /**
   * Obtiene los productos de la categoría seleccionada y actualiza el stock de los productos.
   */
  productosCategoria() {
    this.procesarPedidoService
      .productosCategorias(this.idCategoriaSel)
      .subscribe((productos) => {
        this.productos = productos;
        // Actualiza stock al cambiar de categoria
        this.actualizarStocks();
      });
  }

  /**
   * Actualiza el stock de los productos en función de los elementos presentes en la cesta.
   *
   * Recorre la lista de productos y la lista de elementos en la cesta, reduciendo el stock
   * de cada producto según las unidades correspondientes en la cesta.
   */
  actualizarStocks() {
    this.productos.forEach((p) => {
      this.cesta.forEach((c) => {
        if (p.idProducto === c.producto.idProducto) {
          p.stock -= c.unidades;
        }
      });
    });
  }

  /**
   * Agrega un producto a la cesta y reduce el stock del producto.
   *
   * @param {Producto} producto - El producto que se va a agregar a la cesta.
   */
  agregarProductoCesta(producto: Producto) {
    if (producto.unidades <= producto.stock) {
      let item: CestaItem = new CestaItem();
      item.producto = producto;
      item.unidades = producto.unidades;
      this.cesta.push(item);
      // Actualizar stock
      producto.stock -= producto.unidades;
    } else {
      alert('No hay suficiente stock');
    }
  }

  /**
   * Elimina un producto de la cesta y actualiza el stock del producto original.
   *
   * @param {number} posicion - La posición del producto en la cesta que se desea eliminar.
   */
  eliminarProductoCesta(posicion: number) {
    let item = this.cesta[posicion];
    this.cesta.splice(posicion, 1);

    // Actualizar stock
    let producto = this.productos.find(
      (producto) => producto.idProducto === item.producto.idProducto
    );
    producto.stock = Number(producto.stock) + Number(item.unidades);
  }
}
