import { RegistrarService } from './../../service/registrar.service';
import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/model/Cliente';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registrar',
  templateUrl: './registrar.component.html',
  styleUrls: ['./registrar.component.css']
})
export class RegistrarComponent implements OnInit {
  cliente:Cliente=new Cliente();
  constructor(private registrarService:RegistrarService,
    private router:Router) { }

  ngOnInit(): void {
  }

  registrar(){

      this.registrarService.registrar(this.cliente).subscribe({
          next:data=>this.router.navigate(["/login"]),
          error:err=>alert("El usuario ya existe")
        }
      );

  }
}
