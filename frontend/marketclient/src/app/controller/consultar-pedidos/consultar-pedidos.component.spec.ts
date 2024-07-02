import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultarPedidosComponent } from './consultar-pedidos.component';

describe('ConsultarPedidosComponent', () => {
  let component: ConsultarPedidosComponent;
  let fixture: ComponentFixture<ConsultarPedidosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ConsultarPedidosComponent]
    });
    fixture = TestBed.createComponent(ConsultarPedidosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
