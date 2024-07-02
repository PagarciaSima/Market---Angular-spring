import { LoginComponent } from './controller/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConsultarPedidosComponent } from './controller/consultar-pedidos/consultar-pedidos.component';
import { ProcesarPedidoComponent } from './controller/procesar-pedido/procesar-pedido.component';
import { RegistrarComponent } from './controller/registrar/registrar.component';
import { PortadaComponent } from './controller/portada/portada.component';

const routes: Routes = [
  {path: "login", component: LoginComponent},
  {path: "consultar", component: ConsultarPedidosComponent},
  {path: "procesar", component: ProcesarPedidoComponent},
  {path: "registrar", component: RegistrarComponent},
  {path: "portada", component: PortadaComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
