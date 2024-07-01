import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcesarPedidoComponent } from './procesar-pedido.component';

describe('ProcesarPedidoComponent', () => {
  let component: ProcesarPedidoComponent;
  let fixture: ComponentFixture<ProcesarPedidoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProcesarPedidoComponent]
    });
    fixture = TestBed.createComponent(ProcesarPedidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
