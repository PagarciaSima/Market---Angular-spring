import { Component, OnInit } from '@angular/core';
import { ConsultarPedidosService } from '../../service/consultar-pedidos.service';
import { Pedido } from 'src/app/model/Pedido';

@Component({
  selector: 'app-consultar-pedidos',
  templateUrl: './consultar-pedidos.component.html',
  styleUrls: ['./consultar-pedidos.component.css']
})
export class ConsultarPedidosComponent implements OnInit{

  pedidos: Pedido[];
  usuario: string = "user1";

  constructor(private consultarPedidosService: ConsultarPedidosService) {

  }

  ngOnInit(): void {
    this.consultarPedidosService.consultarPedidos(this.usuario).subscribe(p => this.pedidos = p);
  }
}
