import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProcesarPedidoService {

  constructor(private http: HttpClient) { }

  categorias(): Observable<any> {
    let url ="http://localhost:8082/categorias";
    return this.http.get(url);
  }

  productosCategorias(idCategoria: number): Observable<any> {
    let url ="http://localhost:8082/productos";
    let params = new HttpParams();
    params = params.append("idCategoria", idCategoria);
    return this.http.get(url, {"params": params});
  }
}
