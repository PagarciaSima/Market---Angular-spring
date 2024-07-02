import { Component } from '@angular/core';
import { LoginService } from '../../service/login.service';
import { Cliente } from 'src/app/model/Cliente';
import { MenuComponent } from '../menu/menu.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  usuario: string;
  password: string;
  client: Cliente;

  constructor(private loginService: LoginService, private menuComponent: MenuComponent) {

  }

  login() {
    this.loginService.login(this.usuario, this.password).subscribe(data => {
      this.client = data;
      // Usuario logado o válido
      if(this.client != null) {
        this.menuComponent.cliente = this.client;
        this.menuComponent.enabled = true;
        alert("Usuario autenticado");
      } else {
        alert("Usuario no autenticado");
      }
    });
  }
}
