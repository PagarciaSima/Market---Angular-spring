import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/model/Cliente';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit{

  enabled: boolean = false;
  cliente: Cliente;

  constructor (private router: Router) {

  }

  ngOnInit(): void {
    this.router.navigate(["/portada"]);
  }
}
