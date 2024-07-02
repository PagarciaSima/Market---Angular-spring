import { TestBed } from '@angular/core/testing';

import { ConsultarPedidosService } from './consultar-pedidos.service';

describe('ConsultarPedidosService', () => {
  let service: ConsultarPedidosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConsultarPedidosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
