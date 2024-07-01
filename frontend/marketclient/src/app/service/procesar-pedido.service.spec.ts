import { TestBed } from '@angular/core/testing';

import { ProcesarPedidoService } from './procesar-pedido.service';

describe('ProcesarPedidoService', () => {
  let service: ProcesarPedidoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProcesarPedidoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
